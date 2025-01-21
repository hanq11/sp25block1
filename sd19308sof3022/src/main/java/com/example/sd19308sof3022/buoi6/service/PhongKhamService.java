package com.example.sd19308sof3022.buoi6.service;

import com.example.sd19308sof3022.buoi6.model.PhongKham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhongKhamService {
    ArrayList<PhongKham> danhSach = new ArrayList<>();

    public PhongKhamService() {
        danhSach.add(new PhongKham(1, "Phong Kham A", "Ha Noi", 123));
        danhSach.add(new PhongKham(2, "Phong Kham B", "Bac Giang", 284));
        danhSach.add(new PhongKham(3, "Phong Kham C", "Bac Ninh", 235));
        danhSach.add(new PhongKham(4, "Phong Kham D", "Ha Nam", 456));
    }

    public ArrayList<PhongKham> getAll() {
        return danhSach;
    }

    public PhongKham getDetail(Integer id) {
        PhongKham phongKham = null;
        for(PhongKham pk: danhSach) {
            if(pk.getId() == id) {
                phongKham = pk;
            }
        }
        return phongKham;
    }

    public void addPhongKham(PhongKham phongKham) {
        danhSach.add(phongKham);
    }

    public void updatePhongKham(PhongKham phongKham) {
        int index = 0;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == phongKham.getId()) {
                index = i;
            }
        }
        danhSach.set(index, phongKham);
    }

    public void deletePhongKham(Integer id) {
        int index = 0;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == id) {
                index = i;
            }
        }
        danhSach.remove(index);
    }
}
