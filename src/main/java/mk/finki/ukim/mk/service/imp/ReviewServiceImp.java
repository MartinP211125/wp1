package mk.finki.ukim.mk.service.imp;

import mk.finki.ukim.mk.model.Book;
import mk.finki.ukim.mk.model.Review;
import mk.finki.ukim.mk.repository.jpa.BookRepository;
import mk.finki.ukim.mk.repository.jpa.ReviewRepository;
import mk.finki.ukim.mk.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository repository;
    private final BookRepository bookRepository;

    public ReviewServiceImp(ReviewRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public <S extends Review> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public List<Review> findByBookID(Long bookId) {
        return repository.findByBookID(bookId);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public boolean existsReviewByBookId(Long id) {
        return repository.existsReviewByBookId(id);
    }

    public List<Book> getBookInInterval(LocalDateTime from, LocalDateTime to){
        List<Book> books = repository.findInInterval(from, to).stream().map(Review::getBook).toList();
        return books;
    }
    public List<Review> getReviewInInterval(LocalDateTime from, LocalDateTime to){
        return repository.findInInterval(from, to);
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    public Double getAverageScoreBook (Long id){
        int sumOfReview = repository.findAll().stream().filter(r -> r.getBook().getId().equals(id)).mapToInt(Review::getScore).sum();
        return (double) (sumOfReview / repository.findAll().stream().filter(r -> r.getBook().getId().equals(id)).count());
    }

    public Optional<Book> getBestRatedBook() {
        List<Long> bookId = bookRepository.findAll().stream().mapToLong(Book::getId).boxed().toList();
        Double max = (double) 0;
        Long maxId = 0L;
        for (Long id : bookId) {
            Double avg = getAverageScoreBook(id);
            if(max < avg){
                max = avg;
                maxId = id;
            }
        }
        return bookRepository.findById(maxId);
    }
}
