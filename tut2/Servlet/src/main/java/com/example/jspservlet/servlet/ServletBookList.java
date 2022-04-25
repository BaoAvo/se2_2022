package com.example.jspservlet.servlet;

import com.example.jspservlet.dao.BookDAO;
import com.example.jspservlet.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletBookList", value = "/ServletBookList")

public class ServletBookList extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }
    private void getBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookDAO.selectAllBooks();

        request.setAttribute("books", bookList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("booklist.jsp");
        requestDispatcher.forward(request,response);
    }
}