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
        List<Book> result = null;
        if (user != null && user.getUserType() == UserType.ADMIN) {
            String keyword = req.getParameter("keyword");
            if (keyword == null || keyword.equals("")) {
                result = bookManager.getAll();
            } else {
                result = bookManager.getByTitle(keyword);
            }
        } else if (user != null && user.getUserType() == UserType.USER) {
            result = bookManager.getByUser(user);
            }
            req.setAttribute("books", result);
            req.getRequestDispatcher("WEB-INF/allBooks.jsp").forward(req, resp);
        }
    }