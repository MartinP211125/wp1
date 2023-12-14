package mk.finki.ukim.mk.repository.jpa;

import mk.finki.ukim.mk.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    Optional<Author> findById(Long aLong);

    @Query("SELECT a FROM Author a")
    List<Author> findByBookId(Long bookId);
}
