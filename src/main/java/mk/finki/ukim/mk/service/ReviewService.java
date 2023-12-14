package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {

    List<Review> findInInterval(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    <S extends Review> S save(S entity);
    Review findByBookID(@Param("bookId") Long bookId);

    void deleteById(Long aLong);

    boolean existsReviewByBookId(Long id);
}
