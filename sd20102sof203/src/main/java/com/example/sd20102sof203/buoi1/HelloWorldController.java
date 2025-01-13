package com.example.sd20102sof203.buoi1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HelloWorldController", value = {
        "/hien-thi"
})
public class HelloWorldController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println(uri);
        System.out.println("chay vao trong doget");
        req.setAttribute("ten", "SD20102");
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }
}
