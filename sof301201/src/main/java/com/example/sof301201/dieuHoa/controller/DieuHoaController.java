package com.example.sof301201.dieuHoa.controller;

import com.example.sof301201.dieuHoa.model.DieuHoa;
import com.example.sof301201.dieuHoa.repository.DieuHoaRepository;
import com.example.sof301201.dieuHoa.repository.LoaiDieuHoaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DieuHoaController", value = {
        "/dieu-hoa/hien-thi", // GET
        "/dieu-hoa/view-update", // GET
        "/dieu-hoa/detail", // GET
        "/dieu-hoa/delete", // GET
        "/dieu-hoa/add", // POST
        "/dieu-hoa/update" // POST
})
public class DieuHoaController extends HttpServlet {
    private DieuHoaRepository dieuHoaRepository = new DieuHoaRepository();
    private LoaiDieuHoaRepository loaiDieuHoaRepository = new LoaiDieuHoaRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("detail")) {
            detail(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        dieuHoaRepository.xoa(id);
        resp.sendRedirect("/dieu-hoa/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("dieuHoa", dieuHoaRepository.getOne(id));
        req.getRequestDispatcher("/dieuHoa/detail.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("dieuHoa", dieuHoaRepository.getOne(id));
        req.setAttribute("listLoaiDieuHoa", loaiDieuHoaRepository.getAllLoaiDieuHoa());
        req.getRequestDispatcher("/dieuHoa/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listLoaiDieuHoa", loaiDieuHoaRepository.getAllLoaiDieuHoa());
        req.setAttribute("listDieuHoa", dieuHoaRepository.getAll());
        req.getRequestDispatcher("/dieuHoa/hien-thi.jsp").forward(req, resp);
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
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Integer idLoaiDieuHoa = Integer.valueOf(req.getParameter("idLoaiDieuHoa"));
        DieuHoa dh = new DieuHoa(id, ten, gia, soLuong, loaiDieuHoaRepository.getOne(idLoaiDieuHoa));
        dieuHoaRepository.sua(dh);
        resp.sendRedirect("/dieu-hoa/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Integer idLoaiDieuHoa = Integer.valueOf(req.getParameter("idLoaiDieuHoa"));
        DieuHoa dh = new DieuHoa(null, ten, gia, soLuong, loaiDieuHoaRepository.getOne(idLoaiDieuHoa));
        dieuHoaRepository.them(dh);
        resp.sendRedirect("/dieu-hoa/hien-thi");
    }
}
