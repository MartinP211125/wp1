package mk.finki.ukim.mk.web.controller;


import jakarta.annotation.Nullable;
import mk.finki.ukim.mk.model.Review;
import mk.finki.ukim.mk.service.BookService;
import mk.finki.ukim.mk.service.BookStoreService;
import mk.finki.ukim.mk.service.ReviewService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;
    public final BookStoreService bookStoreService;
    public final ReviewService reviewService;

    public BookController(BookService bookService, BookStoreService bookStoreService, ReviewService reviewService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.reviewService = reviewService;
    }


    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("review", reviewService);
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

    @GetMapping("/review/{bookId}")
    public String Review(@PathVariable Long bookId, Model model){
        model.addAttribute("bookId", bookId);
        return "review";
    }

    @PostMapping("review/add")
    public String addReview(@RequestParam Long bookId, @RequestParam int score, @RequestParam String description, @RequestParam LocalDateTime timestamp, Model model){
        Review rev = new Review(score, description, bookService.findBookById(bookId), timestamp);
        reviewService.save(rev);
        return "redirect:/books";
    }

    @GetMapping("/add-form")
    public String getAddBookPage(Model model){
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("bookId", null);
        return "editBook";
    }

    @GetMapping("/filter")
    public String filterByInterval(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from, @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to, Model model) {
        model.addAttribute("books", reviewService.getBookInInterval(from, to));
        model.addAttribute("review", reviewService);
        return "listBooks";
    }
}
