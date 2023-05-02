package com.example.myLibrary.servlet;

import com.example.myLibrary.constants.SharedConstants;
import com.example.myLibrary.manager.AuthorManager;
import com.example.myLibrary.manager.BookManager;
import com.example.myLibrary.model.Author;
import com.example.myLibrary.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();
    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorManager.getAll();
        req.setAttribute("authorsList", authors);
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
            profilePic.write(SharedConstants.UPLOAD_FOLDER + picName);
        }
        Book book = Book.builder().title(title)
                .id(id).description(description)
                .price(price)
                .author(authorManager.getById(authorId))
                .PicName(picName)
                .build();
        bookManager.update(book);
        resp.sendRedirect("/allBooks");
    }
    }
