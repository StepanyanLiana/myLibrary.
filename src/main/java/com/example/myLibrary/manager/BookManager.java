package com.example.myLibrary.manager;

import com.example.myLibrary.db.DBConnectProvider;
import com.example.myLibrary.model.Author;
import com.example.myLibrary.model.Book;
import com.example.myLibrary.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private Connection connection = DBConnectProvider.getInstance().getConnection();
    AuthorManager authorManager = new AuthorManager();
    UserManager userManager = new UserManager();
    public void save(Book book) {
        String sql = "INSERT INTO book(title,description,price,author_id,pic_name,user_id) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setString(5, book.getPicName());
            ps.setInt(6, (book.getUser().getId()));
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                book.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getById(int id) {
        String sql = "Select * from book where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Book> getByUser(User user) {
        List<Book> bookList = new ArrayList<>();
        String sql = "Select * from book where user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book bookFromResultSet = getBookFromResultSet(resultSet);
                bookList.add(bookFromResultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String sql = "Select * from book";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        int authorId = resultSet.getInt("author_id");
        int userId = resultSet.getInt("user_id");
        Author byId = authorManager.getById(authorId);
        User byUserId = userManager.getById(userId);
        return Book.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .description(resultSet.getString("description"))
                .price(resultSet.getInt("price"))
                 .author(byId)
                .picName(resultSet.getString("pic_name"))
                .user(byUserId)
                .build();
    }
    public void removeById(int bookId) {
        String sql = "DELETE FROM book WHERE id = " + bookId;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Book book) {
        String sql = "UPDATE book SET title = ?, description = ?, price = ?, author_id = ?, pic_name = ?, user_id = ? WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setString(5, book.getPicName());
            ps.setInt(6, book.getUser().getId());
            ps.setInt(7, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Book> getByTitle(String keyword) {
        List<Book> bookList = new ArrayList<>();
        String sql = "Select * from book where title like ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            keyword = "%" + keyword + "%";
            preparedStatement.setString(1, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookList.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
