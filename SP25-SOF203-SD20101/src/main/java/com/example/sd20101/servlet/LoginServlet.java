package com.example.sd20101.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/trang-chu",
        "/login",
})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/login")) {
            // lay thong tin tren form
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (email.equals("nguyenvv4") && password.equals("123")) {
                // mo trang home
                request.setAttribute("email", email);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            }else {
                System.out.println("Login khong dung");
            }
        }
    }
}
