package com.example.sd20102sof203.buoi10.repository;

import com.example.sd20102sof203.buoi10.model.Vali;
import com.example.sd20102sof203.buoi10.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValiRepository {
    private Connection conn = null;

    public ValiRepository() {
        conn = DbConnection.getConnection();
    }

    public List<Vali> getAll() {
        String sql = "SELECT * FROM vali";
        List<Vali> danhSach = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                Integer gia = rs.getInt("gia");
                danhSach.add(new Vali(ma, ten, gia));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public Vali getOne(String ma) {
        String sql = "SELECT * FROM Vali WHERE ma = ?";
        Vali vali = new Vali();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                vali.setMa(rs.getString("ma"));;
                vali.setTen(rs.getString("ten"));
                vali.setGia(rs.getInt("gia"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vali;
    }

    public void add(Vali vali) {
        String sql = "INSERT INTO Vali (ma, ten, gia) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vali.getMa());
            ps.setString(2, vali.getTen());
            ps.setInt(3, vali.getGia());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Vali vali) {
        String sql = "UPDATE Vali SET ten = ?, gia = ? WHERE ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vali.getTen());
            ps.setInt(2, vali.getGia());
            ps.setString(3, vali.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String ma) {
        String sql = "DELETE FROM Vali WHERE ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
