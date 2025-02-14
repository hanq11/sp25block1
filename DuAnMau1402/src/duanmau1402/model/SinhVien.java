/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau1402.model;

/**
 *
 * @author Syn
 */
public class SinhVien {
    private Integer maSinhVien;
    private String ten;
    private Integer tuoi;
    private String ngaySinh;
    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(Integer maSinhVien, String ten, Integer tuoi, String ngaySinh, String diaChi) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.tuoi = tuoi;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public Integer getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(Integer maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
