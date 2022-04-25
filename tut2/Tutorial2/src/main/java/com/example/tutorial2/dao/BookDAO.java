package com.example.tutorial2.dao;

import com.example.tutorial2.dbconnect.DBConnect;
import com.example.tutorial2.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    Connection connection;
    public BookDAO(){
        connection = DBConnect.getConnection();
    }

    public List<Book> selectAllBooks(){
        List<Book> bookList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM book";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");
                bookList.add(new Book(id,title,author,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

}

