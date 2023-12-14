package mk.finki.ukim.mk.service.imp;

import mk.finki.ukim.mk.model.Review;
import mk.finki.ukim.mk.repository.jpa.ReviewRepository;
import mk.finki.ukim.mk.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository repository;

    public ReviewServiceImp(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Review> findInInterval(LocalDateTime from, LocalDateTime to) {
        return repository.findInInterval(from, to);
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
}
