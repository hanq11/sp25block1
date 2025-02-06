package com.example.sd20102sof203.sinhVien.controller;

import com.example.sd20102sof203.sinhVien.model.SinhVien;
import com.example.sd20102sof203.sinhVien.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/detail", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/xoa", // GET
        "/sinh-vien/add", // POST
        "/sinh-vien/update" // POST
})
public class SinhVienController extends HttpServlet {
    SinhVienService sinhVienService = new SinhVienService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("detail")) {
            detail(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sinhVien", sinhVienService.getOne(id));
        req.getRequestDispatcher("/sinh-vien/view-update.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sinhVien", sinhVienService.getOne(id));
        req.getRequestDispatcher("/sinh-vien/detail.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSinhVien", sinhVienService.getAll());
        req.getRequestDispatcher("/sinh-vien/hien-thi.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sinhVienService.xoa(id);
        resp.sendRedirect("/sinh-vien/hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            add(req, resp);
        } else if(uri.contains("update")) {
            update(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float tuoi = Float.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        sinhVienService.sua(new SinhVien(id, ten, tuoi, gioiTinh));
        resp.sendRedirect("/sinh-vien/hien-thi");
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float tuoi = Float.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        sinhVienService.them(new SinhVien(id, ten, tuoi, gioiTinh));
        resp.sendRedirect("/sinh-vien/hien-thi");
    }
}
