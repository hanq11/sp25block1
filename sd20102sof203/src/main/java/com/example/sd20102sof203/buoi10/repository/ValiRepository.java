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
}
