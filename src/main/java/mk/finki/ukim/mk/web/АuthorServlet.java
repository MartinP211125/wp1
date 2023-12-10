package mk.finki.ukim.mk.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import javax.xml.crypto.Data;
import java.io.IOException;

@WebServlet(name = "AuthorServlet", urlPatterns = "/author")
public class АuthorServlet extends HttpServlet {

    public final BookService bookService;
    public final SpringTemplateEngine springTemplateEngine;

    public АuthorServlet(BookService bookService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        ServletContext servletContext = getServletContext();
        String bookIsbn = req.getParameter("bookIsbn");
        servletContext.setAttribute("bookIsbn", bookIsbn);
        context.setVariable("authors", DataHolder.authorList);
        context.setVariable("bookIsbn", bookIsbn);
        springTemplateEngine.process("authorList.html", context, resp.getWriter());
    }
}
