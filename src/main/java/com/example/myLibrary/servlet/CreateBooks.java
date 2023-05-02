package com.example.myLibrary.servlet;

import com.example.myLibrary.constants.SharedConstants;
import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.manager.BookManager;
import com.example.myLibrary.manager.UserManager;
import com.example.myLibrary.model.Author;
import com.example.myLibrary.model.Book;
import com.example.myLibrary.model.User;
import com.example.myLibrary.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/createBooks")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5 ,
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class CreateBooks extends HttpServlet {
    private BookManager bookManager = new BookManager();
    private AuthorManager authorManager = new AuthorManager();
    //private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authorList = authorManager.getAll();
        req.setAttribute("authors", authorList);
        req.getRequestDispatcher("WEB-INF/createBooks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("author_id"));
        Part profilePicPart = req.getPart("profilePic");
        String picName = null;
        if (profilePicPart != null && profilePicPart.getSize() > 0) {
            picName = System.nanoTime() + "_" + profilePicPart.getSubmittedFileName();
            profilePicPart.write(SharedConstants.IMAGE_PATH + picName);
        }
        Book book = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getById(authorId))
                .PicName(picName)
                .build();
        bookManager.save(book);
        resp.sendRedirect("/allBooks");
    }
}

