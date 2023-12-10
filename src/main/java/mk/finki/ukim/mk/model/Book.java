package mk.finki.ukim.mk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.finki.ukim.mk.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
    Long id;
    String isbn;
    String title;
    String genre;
    int year;
    List<Author> authorList;
    BookStore bookStore;

    public Book (String isbn, String title, String genre, int year, List<Author> authorList, BookStore bookStore){
        this.id = (long) (Math.random() * 1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authorList = authorList;
        this.bookStore = bookStore;
    }
}
