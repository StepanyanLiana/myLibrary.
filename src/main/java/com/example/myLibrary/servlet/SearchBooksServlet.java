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

@WebServlet("/searchBooks")
public class SearchBooksServlet extends HttpServlet {
    BookManager bookManager = new BookManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        List<Book> bookList = (List<Book>) bookManager.getByTitle(title);
        if (bookList != null) {
            req.setAttribute("searchBook", bookList);
            req.getRequestDispatcher("WEB-INF/searchBook.jsp").forward(req, resp);
        }
    }
}
