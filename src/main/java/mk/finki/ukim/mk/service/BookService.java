package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> listBooks();


    public Author addAuthorToBook(Long authorId, String isbn);


    public Book findBookByIsbn(String isbn);


    public void deleteBook(Long id);

    public void saveOrEditBook(String title, String isbn, String genre, int year, Long id, Long editId);
}