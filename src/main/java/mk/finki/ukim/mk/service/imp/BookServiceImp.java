package mk.finki.ukim.mk.service.imp;

import jakarta.persistence.EntityNotFoundException;
import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;

import mk.finki.ukim.mk.model.BookStore;
import mk.finki.ukim.mk.repository.jpa.BookRepository;
import mk.finki.ukim.mk.repository.jpa.AuthorRepository;
import mk.finki.ukim.mk.repository.jpa.BookStoreRepository;
import mk.finki.ukim.mk.service.BookService;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImp(BookRepository bookRepository, AuthorRepository authorRepository, BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


    @Override
    public void saveOrEditBook(String title, String isbn, String genre, int year, Long id, Long editId) {
        if(editId != null){
            bookRepository.deleteById(editId);
        }
        BookStore bookStore = bookStoreRepository.getReferenceById(id);
        bookRepository.save(new Book(isbn, title, genre, year, authorRepository.findByBookId(editId), bookStore));
    }

    @Override
    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null){
            return book;
        }
        return null;
    }

    public void addAuthorToBook(Long bookId, Long authorId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("Author not found"));

        book.getAuthorList().add(author);
        bookRepository.save(book);
    }
}
