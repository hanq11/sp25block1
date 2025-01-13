package com.example.sof301201.phongKham.controller;

import com.example.sof301201.phongKham.model.PhongKham;
import com.example.sof301201.phongKham.repository.PhongKhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PhongKhamController", value = {
        "/phong-kham/hien-thi", // GET
        "/phong-kham/view-update", // GET
        "/phong-kham/detail", // GET
        "/phong-kham/delete", // GET
        "/phong-kham/add", // POST
        "/phong-kham/update" // POST
})
public class PhongKhamController extends HttpServlet {
    PhongKhamRepository phongKhamRepository = new PhongKhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("detail")) {
            detail(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        PhongKham phongKham = phongKhamRepository.getOne(id);
        req.setAttribute("phongKham", phongKham);
        req.getRequestDispatcher("/phongKham/view-update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        phongKhamRepository.deleteById(id);
        resp.sendRedirect("/phong-kham/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        PhongKham pk = phongKhamRepository.getOne(id);
        req.setAttribute("phongKham", pk);
        req.getRequestDispatcher("/phongKham/detail.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", phongKhamRepository.getAll());
        req.getRequestDispatcher("/phongKham/hien-thi.jsp").forward(req, resp);
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
        PhongKham phongKham = new PhongKham(id, ten, diaChi);
        phongKhamRepository.update(phongKham);
        resp.sendRedirect("/phong-kham/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        PhongKham phongKham = new PhongKham(null, ten, diaChi);
        phongKhamRepository.add(phongKham);
        resp.sendRedirect("/phong-kham/hien-thi");
    }
}
