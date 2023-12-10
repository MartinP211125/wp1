package mk.finki.ukim.mk.web.controller;


import jakarta.annotation.Nullable;
import mk.finki.ukim.mk.service.BookService;
import mk.finki.ukim.mk.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;
    public final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }


    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("books", bookService.listBooks());
        return "listBooks";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam Long bookId, @RequestParam String title, @RequestParam String isbn, @RequestParam String genre, @RequestParam int year, @RequestParam Long id) {
        try {
            this.bookService.saveOrEditBook(title, isbn, genre, year, id, bookId);
            return "redirect:/books";
        } catch (Exception e) {
            // Log the exception or print its stack trace
            e.printStackTrace();
            return "error"; // Return an error page or handle the error accordingly
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId, Model model) {
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("bookId", bookId);
        return "editBook";
    }
    @GetMapping("/add-form")
    public String getAddBookPage(Model model){
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("bookId", null);
        return "editBook";
    }

}
