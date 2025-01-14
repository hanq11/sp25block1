package com.example.sof301201.phongKham.controller;

import com.example.sof301201.phongKham.model.BacSi;
import com.example.sof301201.phongKham.repository.BacSiRepository;
import com.example.sof301201.phongKham.repository.PhongKhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BacSiController", value = {
        "/bac-si/hien-thi", // GET
        "/bac-si/view-update", // GET
        "/bac-si/detail", // GET
        "/bac-si/delete", // GET
        "/bac-si/add", // POST
        "/bac-si/update" // POST
})
public class BacSiController extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();
    PhongKhamRepository phongKhamRepository = new PhongKhamRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", bacSiRepository.getAll());
        req.setAttribute("listPhongKham", phongKhamRepository.getAll());
        req.getRequestDispatcher("/bacSi/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            add(req, resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Integer luong = Integer.valueOf(req.getParameter("luong"));
        String diaChi = req.getParameter("diaChi");
        Integer idPhongKham = Integer.valueOf(req.getParameter("phongKham"));
        BacSi bacSi = new BacSi(null, ten, luong, diaChi, phongKhamRepository.getOne(idPhongKham));
        bacSiRepository.add(bacSi);
        resp.sendRedirect("/bac-si/hien-thi");
    }
}
