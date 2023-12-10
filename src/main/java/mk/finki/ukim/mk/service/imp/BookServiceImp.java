package mk.finki.ukim.mk.service.imp;

import jakarta.annotation.Nullable;
import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;
import mk.finki.ukim.mk.repository.AuthorRepository;
import mk.finki.ukim.mk.repository.BookRepository;
import mk.finki.ukim.mk.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    public final BookRepository bookRepository;
    public final AuthorRepository authorRepository;

    public BookServiceImp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        return bookRepository.addAuthorToBook(authorRepository.findById(authorId), bookRepository.findByIsbn(isbn));
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public void saveOrEditBook(String title, String isbn, String genre, int year, Long id, Long editId) {
        bookRepository.saveBook(title, isbn, genre, year, id, editId);
    }


}
