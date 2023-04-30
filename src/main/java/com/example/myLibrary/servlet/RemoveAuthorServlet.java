package com.example.myLibrary.servlet;

import com.example.myLibrary.constants.SharedConstants;
import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.manager.BookManager;
import com.example.myLibrary.model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/removeAuthor")
public class RemoveAuthorServlet extends HttpServlet {
private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Author byId = authorManager.getById(id);
        if (byId != null) {
            if (byId.getImage() != null || !byId.getImage().equalsIgnoreCase("null")) {
                File file = new File(SharedConstants.UPLOAD_FOLDER + byId.getImage());
                if (file.exists()) {
                    file.delete();
                }
            }
            authorManager.removeById(id);
        }
        resp.sendRedirect("/allAuthors");
    }
}
