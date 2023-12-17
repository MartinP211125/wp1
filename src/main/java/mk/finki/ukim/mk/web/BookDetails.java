package mk.finki.ukim.mk.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.model.Review;
import mk.finki.ukim.mk.repository.jpa.ReviewRepository;
import mk.finki.ukim.mk.service.AuthorService;
import mk.finki.ukim.mk.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "bookDetails", urlPatterns = "/details")
public class BookDetails extends HttpServlet {

    public final SpringTemplateEngine springTemplateEngine;
    public final BookService bookService;
    public final AuthorService authorService;
    public final ReviewRepository repository;

    public BookDetails(SpringTemplateEngine springTemplateEngine, BookService bookService, AuthorService authorService, ReviewRepository repository) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
        this.authorService = authorService;
        this.repository = repository;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String author = req.getParameter("authorId");
        String bookIsbn = req.getParameter("bookIsbn");
        bookService.addAuthorToBook(bookService.findBookByIsbn(bookIsbn).getId(), Long.parseLong(author));
        context.setVariable("book", bookService.findBookByIsbn(bookIsbn));
        context.setVariable("authors", bookService.findBookByIsbn(bookIsbn).getAuthorList());
        context.setVariable("review", repository.findByBookID(bookService.findBookByIsbn(bookIsbn).getId()).stream().map(Review::getScore).findFirst());
        springTemplateEngine.process("bookDetails.html", context, resp.getWriter());
    }
}
