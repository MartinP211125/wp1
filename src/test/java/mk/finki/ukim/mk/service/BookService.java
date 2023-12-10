package mk.finki.ukim.mk.service;

import jakarta.annotation.Nullable;
import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn (String isbn);

    void deleteBook(Long id);

    void saveOrEditBook(String title, String isbn, String genre, int year, Long id, Optional<Long> editId);
}
