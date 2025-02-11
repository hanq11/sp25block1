package com.example.sd20102sof203.buoi10.controller;

import com.example.sd20102sof203.buoi10.repository.ValiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ValiController", value = {
        "/vali/hien-thi", // GET
        "/vali/detail", // GET
        "/vali/view-update", // GET
        "/vali/xoa", // GET
        "/vali/add", // POST
        "/vali/update" // POST
})
public class ValiController extends HttpServlet {
    ValiRepository valiRepository = new ValiRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", valiRepository.getAll());
        req.getRequestDispatcher("/vali/hien-thi.jsp").forward(req, resp);
    }
}
