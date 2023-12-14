package mk.finki.ukim.mk.repository.jpa;

import mk.finki.ukim.mk.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {
    @Override
    List<BookStore> findAll();
}
