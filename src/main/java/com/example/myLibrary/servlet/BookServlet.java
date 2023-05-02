package com.example.myLibrary.servlet;

import com.example.myLibrary.manager.BookManager;
import com.example.myLibrary.manager.UserManager;
import com.example.myLibrary.model.Book;
import com.example.myLibrary.model.User;
import com.example.myLibrary.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allBooks")
public class BookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String keyword = req.getParameter("keyword");
        List<Book> all = null;
        if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.USER) {
            if (keyword == null || keyword.equals("")) {
                all = bookManager.getAll();
            } else {
                all = bookManager.getByTitle(keyword);
            }
        }
       // Book book = new Book();
       // int userId = book.getUser().getId();
       // User byId = userManager.getById(user.getId());
       // if (user.getUserType() == UserType.USER && byId.equals(userId)) {
        // List<Book> byUser = bookManager.getByUser(user);
        // req.setAttribute("books", all);
         //req.getRequestDispatcher("WEB-INF/userBooks.jsp").forward(req, resp);}
        req.setAttribute("books", all);
        req.getRequestDispatcher("WEB-INF/allBooks.jsp").forward(req, resp);
    }
}