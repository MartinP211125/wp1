package mk.finki.ukim.mk.repository;

import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookStoreRepository {
    public List<BookStore> findAll(){
        return DataHolder.bookStores;
    }

}
