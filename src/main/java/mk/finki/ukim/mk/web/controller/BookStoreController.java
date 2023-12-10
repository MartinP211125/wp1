package mk.finki.ukim.mk.web.controller;

import mk.finki.ukim.mk.service.BookService;
import mk.finki.ukim.mk.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookStore")
public class BookStoreController {

    public final BookStoreService bookStoreService;
    public final BookService bookService;

    public BookStoreController(BookStoreService bookStoreService, BookService bookService) {
        this.bookStoreService = bookStoreService;
        this.bookService = bookService;
    }


    @GetMapping
    public String getBookStoreList(Model model){
        model.addAttribute("bookStores", bookStoreService.findAll());
        return "listBookStores";
    }

    @PostMapping("/details")
    public String Details(@RequestParam Long bookStoreId, Model model)
    {
        model.addAttribute("books", bookService.listBooks().stream().filter(r -> r.getBookStore().getId().equals(bookStoreId)));
        return "bookStoreDetails";
    }
}
