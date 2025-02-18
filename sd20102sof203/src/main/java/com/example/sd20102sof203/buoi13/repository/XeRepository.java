package com.example.sd20102sof203.buoi13.repository;

import com.example.sd20102sof203.buoi13.model.Xe;
import com.example.sd20102sof203.buoi13.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class XeRepository {
    private Connection conn = null;

    public XeRepository() {
        conn = DbConnection.getConnection();
    }

    public ArrayList<Xe> getAll() {
        String sql = "SELECT * FROM Xe";
        ArrayList<Xe> danhSach = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                danhSach.add(new Xe(
                    rs.getInt("MaXe"),
                    rs.getString("TenXe"),
                    rs.getString("HangSanXuat"),
                    rs.getFloat("Gia"),
                    rs.getInt("SoLuong"),
                    rs.getString("MauSac"),
                    rs.getString("NgayNhap"),
                    rs.getBoolean("IsNew")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public Xe getOne(Integer maXe) {
        String sql = "SELECT * FROM Xe WHERE MaXe = ?";
        Xe xe = new Xe();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maXe);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                xe.setMaXe(rs.getInt("MaXe"));
                xe.setTenXe(rs.getString("TenXe"));
                xe.setHangSanXuat(rs.getString("HangSanXuat"));
                xe.setGia(rs.getFloat("Gia"));
                xe.setSoLuong(rs.getInt("SoLuong"));
                xe.setMauSac(rs.getString("MauSac"));
                xe.setNgayNhap(rs.getString("NgayNhap"));
                xe.setIsNew(rs.getBoolean("IsNew"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return xe;
    }

    public void add(Xe xe) {
        String sql = "INSERT INTO Xe (MaXe, TenXe, HangSanXuat, Gia, SoLuong, MauSac, NgayNhap, IsNew) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, xe.getMaXe());
            ps.setString(2, xe.getTenXe());
            ps.setString(3, xe.getHangSanXuat());
            ps.setFloat(4, xe.getGia());
            ps.setInt(5, xe.getSoLuong());
            ps.setString(6, xe.getMauSac());
            ps.setString(7, xe.getNgayNhap());
            ps.setBoolean(8, xe.getIsNew());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Xe xe) {
        String sql = "UPDATE Xe SET TenXe = ?, HangSanXuat = ?, Gia = ?, SoLuong = ?, MauSac = ?, NgayNhap = ?, IsNew = ? WHERE MaXe = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xe.getTenXe());
            ps.setString(2, xe.getHangSanXuat());
            ps.setFloat(3, xe.getGia());
            ps.setInt(4, xe.getSoLuong());
            ps.setString(5, xe.getMauSac());
            ps.setString(6, xe.getNgayNhap());
            ps.setBoolean(7, xe.getIsNew());
            ps.setInt(8, xe.getMaXe());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer maXe) {
        String sql = "DELETE FROM Xe WHERE MaXe = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maXe);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
