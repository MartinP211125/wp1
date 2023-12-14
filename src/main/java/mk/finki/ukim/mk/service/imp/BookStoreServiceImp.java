package mk.finki.ukim.mk.service.imp;

import mk.finki.ukim.mk.model.BookStore;
import mk.finki.ukim.mk.repository.InMemoryBookStoreRepository;
import mk.finki.ukim.mk.repository.jpa.BookStoreRepository;
import mk.finki.ukim.mk.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookStoreServiceImp implements BookStoreService{
    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImp(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }


    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }
}
