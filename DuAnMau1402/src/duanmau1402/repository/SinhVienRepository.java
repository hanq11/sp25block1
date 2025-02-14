/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau1402.repository;
import duanmau1402.model.SinhVien;
import duanmau1402.util.DbConnection;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Syn
 */
public class SinhVienRepository {
    private Connection conn;
    
    public SinhVienRepository() {
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<SinhVien> getAll() {
        String sql = "SELECT * FROM SinhVien";
        ArrayList<SinhVien> danhSach = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                Integer maSinhVien = rs.getInt("MaSinhVien");
                String ten = rs.getString("Ten");
                Integer tuoi = rs.getInt("Tuoi");
                String ngaySinh = rs.getString("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                SinhVien sv = new SinhVien(maSinhVien, ten, tuoi, ngaySinh, diaChi);
                danhSach.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public void them(SinhVien sv) {
        String sql = """
                     INSERT INTO SinhVien
                     	(MaSinhVien, Ten, Tuoi, NgaySinh, DiaChi)
                     VALUES
                     	(?, ?, ?, ?, ?);
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sv.getMaSinhVien());
            ps.setString(2, sv.getTen());
            ps.setInt(3, sv.getTuoi());
            ps.setString(4, sv.getNgaySinh());
            ps.setString(5, sv.getDiaChi());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sua(SinhVien sv) {
        String sql = """
                     UPDATE SinhVien
                     SET Ten = ?,
                        Tuoi = ?,
                        NgaySinh = ?,
                        DiaChi = ?
                     WHERE MaSinhVien = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getTen());
            ps.setInt(2, sv.getTuoi());
            ps.setString(3, sv.getNgaySinh());
            ps.setString(4, sv.getDiaChi());
            ps.setInt(5, sv.getMaSinhVien());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void xoa(SinhVien sv) {
        String sql = """
                     DELETE FROM SinhVien WHERE MaSinhVien = ?;
                     """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sv.getMaSinhVien());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
