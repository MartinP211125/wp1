package mk.finki.ukim.mk.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;
import mk.finki.ukim.mk.model.BookStore;
import mk.finki.ukim.mk.model.Review;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authorList;
    public static List<Book> books;
    public static List<BookStore> bookStores;
    public static List<Review> rewievs;

    @PostConstruct
    public void init(){
        authorList = new ArrayList<>();
        books = new ArrayList<>();
        bookStores = new ArrayList<>();
        authorList.add(new Author( "Secker", "Secker", "yes",LocalDate.of(2002, Month.JUNE, 15)));
        authorList.add(new Author("Warburg", "Warburg", "yes", LocalDate.of(1999, Month.SEPTEMBER, 10)));
        authorList.add(new Author("Smith", "Smith", "yes", LocalDate.of(2001, Month.OCTOBER, 5)));
        authorList.add(new Author("Elder", "Elder", "yes", LocalDate.of(1980, Month.JANUARY, 20)));
        authorList.add(new Author("Champman", "Champman", "yes", LocalDate.of(1996, Month.FEBRUARY, 1)));
        authorList.add(new Author("Hall", "Hall", "yes", LocalDate.of(1965, Month.DECEMBER, 7)));
        authorList.add(new Author("Homer", "Homer", "yes", LocalDate.of(2002, Month.JUNE, 15)));

        bookStores.add(new BookStore("Prosveta", "Ohrid", "Sv. Kliment Ohridski"));
        bookStores.add(new BookStore("Prosvetno Delo", "Ohrid", "Dimitar Vlahov"));
        bookStores.add(new BookStore("Snezana", "Ohrid", "Jane Sandanski"));
        bookStores.add(new BookStore("Literatura mk", "Skopje", "Bulevar Partizanski Odredi"));
        bookStores.add(new BookStore("Pelikan", "Struga", "Proleterski Brigadi"));

//        books.add(new Book("Nineteen Eighty-Four", "Science Fiction", 1949, authorList.subList(0, 2), bookStores.get(0)));
//        books.add(new Book("Jane Eyre", "Novel", 1847, authorList.subList(2, 4), bookStores.get(1)));
//        books.add(new Book("Great Expectations", "Novel", 1861, authorList.subList(4, 6), bookStores.get(2)));
//        books.add(new Book("Iliada", "Epic poetry", 1999, authorList.subList(6, 7), bookStores.get(3)));

    }
}
