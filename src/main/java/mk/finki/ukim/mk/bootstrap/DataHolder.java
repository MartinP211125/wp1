package mk.finki.ukim.mk.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;
import mk.finki.ukim.mk.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authorList;
    public static List<Book> books;
    public static List<BookStore> bookStores;

    @PostConstruct
    public void init(){
        authorList = new ArrayList<>();
        books = new ArrayList<>();
        bookStores = new ArrayList<>();
        authorList.add(new Author(1L, "Secker", "Secker", "yes"));
        authorList.add(new Author(2L, "Warburg", "Warburg", "yes"));
        authorList.add(new Author(1L, "Smith", "Smith", "yes"));
        authorList.add(new Author(1L, "Elder", "Elder", "yes"));
        authorList.add(new Author(1L, "Champman", "Champman", "yes"));
        authorList.add(new Author(1L, "Hall", "Hall", "yes"));
        authorList.add(new Author(1L, "Homer", "Homer", "yes"));

        bookStores.add(new BookStore("Prosveta", "Ohrid", "Sv. Kliment Ohridski"));
        bookStores.add(new BookStore("Prosvetno Delo", "Ohrid", "Dimitar Vlahov"));
        bookStores.add(new BookStore("Snezana", "Ohrid", "Jane Sandanski"));
        bookStores.add(new BookStore("Literatura mk", "Skopje", "Bulevar Partizanski Odredi"));
        bookStores.add(new BookStore("Pelikan", "Struga", "Proleterski Brigadi"));

        books.add(new Book("1", "Nineteen Eighty-Four", "Science Fiction", 1949, authorList.subList(0, 2), bookStores.get(0)));
        books.add(new Book("2", "Jane Eyre", "Novel", 1847, authorList.subList(2, 4), bookStores.get(1)));
        books.add(new Book("3", "Great Expectations", "Novel", 1861, authorList.subList(4, 6), bookStores.get(2)));
        books.add(new Book("4", "Iliada", "Epic poetry", 1999, authorList.subList(6, 7), bookStores.get(3)));

    }
}
