package com.example.sd20102sof203.crud.controller;

import com.example.sd20102sof203.crud.service.PhongKhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PhongKhamController", value = {
        "/phong-kham/hien-thi",
        "/phong-kham/detail",
        "/phong-kham/view-update",
        "/phong-kham/xoa",
        "/phong-kham/add",
        "/phong-kham/update"
})
public class PhongKhamController extends HttpServlet {
    PhongKhamService phongKhamService = new PhongKhamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", phongKhamService.getAll());
        req.getRequestDispatcher("/phong-kham/hien-thi.jsp").forward(req, resp);
    }
}
