package mk.finki.ukim.mk.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "BookServlet", urlPatterns = "/listBooks")
public class BookListServlet extends HttpServlet {
    public final BookService bookService;
    public final SpringTemplateEngine springTemplateEngine;
    public BookListServlet(BookService bookService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String name = req.getParameter("Name");
        if(name != null){
            if(!name.isEmpty()){
                context.setVariable("books", bookService.listBooks().stream().filter(r -> r.getTitle().equals(name)));
            }
        }
        else{
            context.setVariable("books", bookService.listBooks());
        }
        springTemplateEngine.process("listBooks.html", context, resp.getWriter());
    }
}
