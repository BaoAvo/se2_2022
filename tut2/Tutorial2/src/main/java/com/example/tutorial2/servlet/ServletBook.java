package com.example.tutorial2.servlet;

import com.example.tutorial2.dao.BookDAO;
import com.example.tutorial2.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")

public class ServletBook extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getBookList(request,response);
    }

    private void getBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookDAO.selectAllBooks();

        request.setAttribute("books", bookList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("booklist.jsp");
        requestDispatcher.forward(request, response);
    }
}
