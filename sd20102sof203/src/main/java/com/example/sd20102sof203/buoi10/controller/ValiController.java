package com.example.sd20102sof203.buoi10.controller;

import com.example.sd20102sof203.buoi10.model.Vali;
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
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ma = req.getParameter("ma");
        valiRepository.delete(ma);
        resp.sendRedirect("/vali/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        req.setAttribute("vali", valiRepository.getOne(ma));
        req.getRequestDispatcher("/vali/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", valiRepository.getAll());
        req.getRequestDispatcher("/vali/hien-thi.jsp").forward(req, resp);
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
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer gia = Integer.valueOf(req.getParameter("gia"));
        Vali vali = new Vali(ma, ten, gia);
        valiRepository.update(vali);
        resp.sendRedirect("/vali/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer gia = Integer.valueOf(req.getParameter("gia"));
        Vali vali = new Vali(ma, ten, gia);
        valiRepository.add(vali);
        resp.sendRedirect("/vali/hien-thi");
    }
}
