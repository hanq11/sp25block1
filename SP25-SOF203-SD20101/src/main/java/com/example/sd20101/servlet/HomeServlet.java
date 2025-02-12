package com.example.sd20101.servlet;

import com.example.sd20101.model.User;
import com.example.sd20101.repository.UserRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = {"/HomeServlet",
        "/home",
        "/user/hien-thi",// hien thi 1 danh sach user
        "/user/add", //post
        "/user/detail",
        "/user/update",
        "/user/delete",

})
public class HomeServlet extends HttpServlet {

    UserRepo userRepo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/user/hien-thi")) {
            // thuc hien hien thi danh sach tu repo
            List<User> listUser = userRepo.getUsers();
            request.setAttribute("listUser", listUser);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if(uri.equals("/user/detail")) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            User user = userRepo.getUser(id);
            request.setAttribute("detail", user);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if(uri.equals("/user/delete")) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            userRepo.delete(id);
            response.sendRedirect("/user/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/user/add")) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String hoTen = request.getParameter("hoTen");
            Integer tuoi = Integer.valueOf(request.getParameter("tuoi"));
            String diaChi = request.getParameter("diaChi");
            String gioiTinh = request.getParameter("gioiTinh");

            User user = new User(id, hoTen, tuoi, diaChi, gioiTinh);
            userRepo.addUser(user);
            response.sendRedirect("/user/hien-thi");
        } else if(uri.equals("/user/update")) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String hoTen = request.getParameter("hoTen");
            Integer tuoi = Integer.valueOf(request.getParameter("tuoi"));
            String diaChi = request.getParameter("diaChi");
            String gioiTinh = request.getParameter("gioiTinh");

            User user = new User(id, hoTen, tuoi, diaChi, gioiTinh);
            userRepo.updateUser(user);
            response.sendRedirect("/user/hien-thi");
        }

    }

    /*
    Tao doi tuong hoc sinh: id, ho ten, diem, ngay sinh, gioi tinh
    Hien thi 10 hoc sinh len giao dien, nếu điểm <5 => Trạng thái fail, ngưược lại pass
     */
}
