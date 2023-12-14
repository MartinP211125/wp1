package mk.finki.ukim.mk.repository.jpa;

import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    List<Book> findAll();


    Book findByIsbn(String isbn);

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    void deleteById(Long aLong);


    @Override
    <S extends Book> S save(S entity);
}
