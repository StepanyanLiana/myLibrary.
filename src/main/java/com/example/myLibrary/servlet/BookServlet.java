package com.example.myLibrary.servlet;

import com.example.myLibrary.manager.BookManager;
import com.example.myLibrary.model.Book;

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

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> all = bookManager.getAll();
        req.setAttribute("books", all);
        req.getRequestDispatcher("WEB-INF/allBooks.jsp").forward(req, resp);
    }
}
