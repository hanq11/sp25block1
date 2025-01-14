package com.example.sd20102sof203.crud.service;

import com.example.sd20102sof203.crud.model.PhongKham;

import java.util.ArrayList;

public class PhongKhamService {
    ArrayList<PhongKham> list = new ArrayList<>();

    public PhongKhamService() {
        list.add(new PhongKham(1, "Phong kham A", "Ha Noi", 345));
        list.add(new PhongKham(2, "Phong kham B", "Thai Nguyen", 456));
        list.add(new PhongKham(3, "Phong kham C", "Tay Nguyen", 789));
    }

    public ArrayList<PhongKham> getAll() {
        return list;
    }
}
