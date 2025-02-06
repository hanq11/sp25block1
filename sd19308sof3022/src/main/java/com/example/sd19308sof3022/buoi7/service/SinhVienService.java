package com.example.sd19308sof3022.buoi7.service;

import com.example.sd19308sof3022.buoi7.model.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SinhVienService {
    ArrayList<SinhVien> danhSach = new ArrayList<>();

    public SinhVienService() {
        danhSach.add(new SinhVien(1, "Nguyen Van A", 13.5f, true));
        danhSach.add(new SinhVien(2, "Tran Thi B", 17.5f, false));
        danhSach.add(new SinhVien(3, "Nguyen C", 19.5f, true));
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

    public ArrayList<SinhVien> getAll() {
        return danhSach;
    }

    public void them(SinhVien sv) {
        danhSach.add(sv);
    }

    public void sua(SinhVien sv) {
        int indexSua = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == sv.getId()) {
                indexSua = i;
            }
        }
        danhSach.set(indexSua, sv);
    }

    public void xoa(Integer id) {
        int indexXoa = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == id) {
                indexXoa = i;
            }
        }
        danhSach.remove(indexXoa);
    }
}
