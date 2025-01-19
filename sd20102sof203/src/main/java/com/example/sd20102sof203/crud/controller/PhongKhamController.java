package com.example.sd20102sof203.crud.controller;

import com.example.sd20102sof203.crud.model.PhongKham;
import com.example.sd20102sof203.crud.service.PhongKhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PhongKhamController", value = {
        "/phong-kham/hien-thi", // GET
        "/phong-kham/detail", // GET
        "/phong-kham/view-update", // GET
        "/phong-kham/xoa", // GET
        "/phong-kham/add", // POST
        "/phong-kham/update" // POST
})
public class PhongKhamController extends HttpServlet {
    PhongKhamService phongKhamService = new PhongKhamService();

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

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        phongKhamService.delete(id);
        resp.sendRedirect("/phong-kham/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("phongKham", phongKhamService.detail(id));
        req.getRequestDispatcher("/phong-kham/view-update.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("phongKham", phongKhamService.detail(id));
        req.getRequestDispatcher("/phong-kham/detail.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", phongKhamService.getAll());
        req.getRequestDispatcher("/phong-kham/hien-thi.jsp").forward(req, resp);
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
        String diaChi = req.getParameter("diaChi");
        Integer soNha = Integer.valueOf(req.getParameter("soNha"));
        PhongKham pk = new PhongKham(id, ten, diaChi, soNha);
        phongKhamService.update(pk);
        // Sử dụng sendRedirect khi thực hiện thay đổi dữ liệu (thêm sửa xóa)
        resp.sendRedirect("/phong-kham/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        Integer soNha = Integer.valueOf(req.getParameter("soNha"));
        PhongKham pk = new PhongKham(id, ten, diaChi, soNha);
        phongKhamService.add(pk);
        // Sử dụng sendRedirect khi thực hiện thay đổi dữ liệu (thêm sửa xóa)
        resp.sendRedirect("/phong-kham/hien-thi");
    }
}
