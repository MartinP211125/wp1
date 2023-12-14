package mk.finki.ukim.mk.repository;

import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.Author;
import mk.finki.ukim.mk.model.Book;
import mk.finki.ukim.mk.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryBookRepository {

    public List<Book> findAll (){
        return DataHolder.books;
    }

    public Book findByIsbn(String isbn){
        Optional<Book> var = DataHolder.books.stream().filter(r -> r.getIsbn().equals(isbn)).findFirst();
        return var.orElse(null);
    }

    public Author addAuthorToBook (Author author, Book book){
        DataHolder.books.stream().filter(r -> r.getTitle().equals(book.getTitle())).forEach(r -> r.getAuthorList().add(author));
        return  author;
    }
    public void deleteBook(Long id){
        DataHolder.books.removeIf(r -> r.getId().equals(id));
    }

//    public void saveBook(String title, String isbn, String genre, int year, Long id, Long editId){
//        if(editId != null){
//            DataHolder.books.removeIf(r -> r.getId().equals(editId));
//        }
//        BookStore bookStore = (BookStore) DataHolder.bookStores.stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("No BookStore found with ID: " + id));
//        DataHolder.books.add(new Book(title, genre, year,new ArrayList<Author>(), bookStore));
//    }
}
