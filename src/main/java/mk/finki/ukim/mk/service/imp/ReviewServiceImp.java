package mk.finki.ukim.mk.service.imp;

import mk.finki.ukim.mk.model.Book;
import mk.finki.ukim.mk.model.Review;
import mk.finki.ukim.mk.repository.jpa.ReviewRepository;
import mk.finki.ukim.mk.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository repository;

    public ReviewServiceImp(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public <S extends Review> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Review findByBookID(Long bookId) {
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
}
