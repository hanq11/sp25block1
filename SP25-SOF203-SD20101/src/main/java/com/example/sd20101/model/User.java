package com.example.sd20101.model;

public class User {

    private Integer id;

    private String hoTen;

    private Integer tuoi;

    private String diaChi;
    private String gioiTinh;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    public User(Integer id, String hoTen, Integer tuoi, String diaChi) {
        this.id = id;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    public User(Integer id, String hoTen, Integer tuoi, String diaChi, String gioiTinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public User() {
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
