package com.example.sd19301sof3022.buoi7.service;

import com.example.sd19301sof3022.buoi7.model.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SinhVienService {
    ArrayList<SinhVien> danhSach = new ArrayList<>();

    public SinhVienService() {
        danhSach.add(new SinhVien(1, "Nguyen Van A", 14f, true));
        danhSach.add(new SinhVien(2, "Nguyen Thi C", 15f, false));
        danhSach.add(new SinhVien(3, "Nguyen Vo B", 16f, true));
    }

    public ArrayList<SinhVien> getAll() {
        return danhSach;
    }

    public SinhVien getOne(Integer id) {
        SinhVien sinhVienCanTim = null;
        for(SinhVien sv: danhSach) {
            if(sv.getId() == id) {
                sinhVienCanTim = sv;
            }
        }
        return sinhVienCanTim;
    }

    public void add(SinhVien sv) {
        danhSach.add(sv);
    }

    public void update(SinhVien sv) {
        int indexUpdate = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == sv.getId()) {
                indexUpdate = i;
            }
        }
        danhSach.set(indexUpdate, sv);
    }

    public void delete(Integer id) {
        int indexDelete = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == id) {
                indexDelete = i;
            }
        }
        danhSach.remove(indexDelete);
    }
}
