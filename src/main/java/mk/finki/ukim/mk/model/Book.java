package mk.finki.ukim.mk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import mk.finki.ukim.mk.service.BookService;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String isbn;
    String title;
    String genre;
    int year;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author_list",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    List<Author> authorList;
    @ManyToOne
    BookStore bookStore;

    public Book (String isbn, String title, String genre, int year, List<Author> authorList, BookStore bookStore){
        this.isbn = isbn;
        this.authorList = new ArrayList<>();
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authorList = authorList;
        this.bookStore = bookStore;
    }

    public Book() {

    }
}
