package com.example.sd20102sof203.buoi13.controller;

import com.example.sd20102sof203.buoi10.model.Vali;
import com.example.sd20102sof203.buoi10.repository.ValiRepository;
import com.example.sd20102sof203.buoi13.model.Xe;
import com.example.sd20102sof203.buoi13.repository.XeRepository;
import com.example.sd20102sof203.buoi13.service.XeService;
import com.example.sd20102sof203.buoi13.service.impl.XeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "XeController", value = {
        "/xe/hien-thi", // GET
        "/xe/detail", // GET
        "/xe/view-update", // GET
        "/xe/xoa", // GET
        "/xe/add", // POST
        "/xe/update", // POST
        "/xe/sap-xep", // GET
        "/xe/tim-kiem" //Get
})
public class XeController extends HttpServlet {
    XeRepository xeRepository = new XeRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoa(req, resp);
        } else if(uri.contains("sap-xep")) {
            sapXep(req, resp);
        } else if(uri.contains("tim-kiem")) {
            timKiem(req, resp);
        }
    }

    private void timKiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenXe = req.getParameter("tenXe");
        req.setAttribute("danhSach", xeRepository.timKiemTheoTen(tenXe));
        req.getRequestDispatcher("/xe/hien-thi.jsp").forward(req, resp);
    }

    private void sapXep(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", xeRepository.sapXepTheoTen());
        req.getRequestDispatcher("/xe/hien-thi.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer maXe = Integer.valueOf(req.getParameter("maXe"));
        xeRepository.delete(maXe);
        resp.sendRedirect("/xe/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer maXe = Integer.valueOf(req.getParameter("maXe"));
        req.setAttribute("xe", xeRepository.getOne(maXe));
        req.getRequestDispatcher("/xe/view-update.jsp").forward(req, resp);
    }

    XeServiceImpl xeServiceImpl = new XeServiceImpl();
    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", xeServiceImpl.getAll());
        req.getRequestDispatcher("/xe/hien-thi.jsp").forward(req, resp);
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
        Integer maXe = Integer.valueOf(req.getParameter("maXe"));
        String tenXe = req.getParameter("tenXe");
        String hangSanXuat = req.getParameter("hangSanXuat");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        String mauSac = req.getParameter("mauSac");
        String ngayNhap = req.getParameter("ngayNhap");
        Boolean isNew = Boolean.valueOf(req.getParameter("isNew"));
        Xe xe = new Xe(maXe, tenXe, hangSanXuat, gia, soLuong, mauSac, ngayNhap, isNew);
        xeRepository.update(xe);
        resp.sendRedirect("/xe/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer maXe = Integer.valueOf(req.getParameter("maXe"));
        String tenXe = req.getParameter("tenXe");
        if(tenXe != null && tenXe.trim().isEmpty()) {
            req.setAttribute("tenError", "Khong duoc de trong ten");
            req.getRequestDispatcher("/xe/hien-thi.jsp").forward(req, resp);
        }
        String hangSanXuat = req.getParameter("hangSanXuat");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        String mauSac = req.getParameter("mauSac");
        String ngayNhap = req.getParameter("ngayNhap");
        Boolean isNew = Boolean.valueOf(req.getParameter("isNew"));
        Xe xe = new Xe(maXe, tenXe, hangSanXuat, gia, soLuong, mauSac, ngayNhap, isNew);
        xeRepository.add(xe);
        resp.sendRedirect("/xe/hien-thi");
    }
}
