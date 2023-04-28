package com.example.myLibrary.servlet;

import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.model.Author;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allAuthors")
public class AuthorServlet extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> all = authorManager.getAll();
        req.setAttribute("authors", all);
        req.getRequestDispatcher("WEB-INF/allAuthors.jsp").forward(req, resp);
    }
}
