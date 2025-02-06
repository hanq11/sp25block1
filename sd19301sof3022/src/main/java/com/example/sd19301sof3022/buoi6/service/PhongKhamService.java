package com.example.sd19301sof3022.buoi6.service;

import com.example.sd19301sof3022.buoi6.model.PhongKham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhongKhamService {
    ArrayList<PhongKham> danhSach = new ArrayList<>();

    public PhongKhamService() {
        danhSach.add(new PhongKham(1, "Phong Kham A", "Ha Noi", 123));
        danhSach.add(new PhongKham(2, "Phong Kham B", "Bac Giang", 1234));
        danhSach.add(new PhongKham(3, "Phong Kham C", "Hai Phong", 456));
        danhSach.add(new PhongKham(4, "Phong Kham D", "Bac Ninh", 686));
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
        int indexToUpdate = 0;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == phongKham.getId()) {
                indexToUpdate = i;
            }
        }
        danhSach.set(indexToUpdate, phongKham);
    }

    public void deletePhongKham(Integer id) {
        int indexToDelete = 0;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == id) {
                indexToDelete = i;
            }
        }
        danhSach.remove(indexToDelete);
    }
}
