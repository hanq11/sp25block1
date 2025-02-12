package com.example.sd20101.repository;

import com.example.sd20101.model.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserRepo {

    // lay ra danh sach User(nam trong csdl)

    public List<User> getUsers() {

        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                User user = new User();
                user.setId(re.getInt("id"));
                user.setHoTen(re.getString("hoTen"));
                user.setTuoi(re.getInt("tuoi"));
                user.setDiaChi(re.getString("diaChi"));
                user.setGioiTinh(re.getString("gioiTinh"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO Users (id, hoTen, tuoi, diaChi, gioiTinh) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getHoTen());
            ps.setInt(3, user.getTuoi());
            ps.setString(4, user.getDiaChi());
            ps.setString(5, user.getGioiTinh());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE Users SET hoTen = ?, tuoi = ?, diaChi = ?, gioiTinh = ? WHERE id = ?";
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getHoTen());
            ps.setInt(2, user.getTuoi());
            ps.setString(3, user.getDiaChi());
            ps.setString(4, user.getGioiTinh());
            ps.setInt(5, user.getId());
            ps.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(Integer id) {
        String sql = "select * from users where id = ?";
        User user = new User();
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                user.setId(re.getInt("id"));
                user.setHoTen(re.getString("hoTen"));
                user.setTuoi(re.getInt("tuoi"));
                user.setDiaChi(re.getString("diaChi"));
                user.setGioiTinh(re.getString("gioiTinh"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
