package com.example.myLibrary.servlet;

import com.example.myLibrary.constants.SharedConstants;
import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/createAuthors")
@MultipartConfig(
maxFileSize = 1024 * 1024 * 5 ,//5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class CreateAuthors extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/createAuthors.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = new Author();
        Part profilePic = req.getPart("profilePic");
        String picName = null;
        if (profilePic != null && profilePic.getSize() > 0) {
            picName = System.nanoTime() + "_" + profilePic.getSubmittedFileName();
            profilePic.write(SharedConstants.UPLOAD_FOLDER + picName);
        }
        author.setName(req.getParameter("name"));
    author.setSurname( req.getParameter("surname"));
    author.setEmail(req.getParameter("email"));
    author.setAge(Integer.parseInt(req.getParameter("age")));
    author.setImage(picName);
    authorManager.save(author);
    resp.sendRedirect("/allAuthors");
    }
}
