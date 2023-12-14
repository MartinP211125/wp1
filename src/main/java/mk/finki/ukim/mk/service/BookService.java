package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Book;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> listBooks();

    public void addAuthorToBook(Long bookId, Long authorId);


    public Book findBookByIsbn(String isbn);


    public void deleteBook(Long id);

    public void saveOrEditBook(String title, String isbn, String genre, int year, Long id, Long editId);

    public Book findBookById(Long id);
}