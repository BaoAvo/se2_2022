package com.example.tut2.servlet;

import com.example.tut2.dao.BookDAO;
import com.example.tut2.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private BookDAO bookDao;

    public void  init(){
        bookDao = new BookDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getBookList(request,response);
    }

    private void getBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listBook = bookDao.selectAllBooks();
        request.setAttribute("books",listBook);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("booklist.jsp");
        requestDispatcher.forward(request,response);
    }
}
