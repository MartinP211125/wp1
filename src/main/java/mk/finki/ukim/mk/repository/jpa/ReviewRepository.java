package mk.finki.ukim.mk.repository.jpa;

import mk.finki.ukim.mk.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.timestamp between :from and :to")
    List<Review> findInInterval(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    @Override
    <S extends Review> S save(S entity);
    @Query("select r from Review r where r.book.id = :bookId")
    Review findByBookID(@Param("bookId") Long bookId);

    @Override
    void deleteById(Long aLong);

    boolean existsReviewByBookId(Long bookId);
}
