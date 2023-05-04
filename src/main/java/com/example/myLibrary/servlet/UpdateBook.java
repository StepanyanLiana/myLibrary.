package com.example.myLibrary.servlet;

import com.example.myLibrary.constants.SharedConstants;
import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.manager.BookManager;
import com.example.myLibrary.manager.UserManager;
import com.example.myLibrary.model.Author;
import com.example.myLibrary.model.Book;
import com.example.myLibrary.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateBook")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5 ,//5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class UpdateBook extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();
    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorManager.getAll();
        req.setAttribute("authorsList", authors);
        List<User> userList = userManager.getAll();
        req.setAttribute("users", userList);
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookManager.getById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("WEB-INF/updateBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("author_id"));
        Part profilePic = req.getPart("profilePic");
        String picName = null;
        if (profilePic != null && profilePic.getSize() > 0) {
            picName = System.nanoTime() + "_" + profilePic.getSubmittedFileName();
            profilePic.write(SharedConstants.IMAGE_PATH + picName);
        }
        int userId = Integer.parseInt(req.getParameter("user_id"));
       Book book = new Book(id, title, description, price, authorManager.getById(authorId),picName, userManager.getById(userId));
        bookManager.update(book);
        resp.sendRedirect("/allBooks");
    }
    }
