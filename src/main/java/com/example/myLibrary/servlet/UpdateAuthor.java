package com.example.myLibrary.servlet;

import com.example.myLibrary.constants.SharedConstants;
import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/updateAuthor")
public class UpdateAuthor extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Author author = authorManager.getById(id);
        req.setAttribute("author", author);
        req.getRequestDispatcher("WEB-INF/updateAuthor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part profilePic = req.getPart("profilePic");
        String picName = null;
        if (profilePic != null && profilePic.getSize() > 0) {
            picName = System.nanoTime() + "_" + profilePic.getSubmittedFileName();
            profilePic.write(SharedConstants.UPLOAD_FOLDER + picName);
        }
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        Author author = new Author(id, name, surname,email, age, picName);
        authorManager.update(author);
        resp.sendRedirect("/allAuthors");

    }
}
