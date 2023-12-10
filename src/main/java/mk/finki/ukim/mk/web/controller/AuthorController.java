package mk.finki.ukim.mk.web.controller;

import jakarta.servlet.ServletContext;
import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.service.AuthorService;
import mk.finki.ukim.mk.service.BookService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@Controller
@RequestMapping("/author-controller")
public class AuthorController {
    public final BookService bookService;
    public final AuthorService authorService;
    public final SpringTemplateEngine springTemplateEngine;

    public AuthorController(BookService bookService, AuthorService authorService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @PostMapping()
    public String getAuthor(@RequestParam String bookIsbn, Model model){
        model.addAttribute("bookIsbn", bookIsbn);
        model.addAttribute("authors", authorService.listAuthors());
        return "authorList";
    }
}
