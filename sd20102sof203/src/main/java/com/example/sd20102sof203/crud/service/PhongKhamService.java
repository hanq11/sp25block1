package com.example.sd20102sof203.crud.service;

import com.example.sd20102sof203.crud.model.PhongKham;

import java.util.ArrayList;

public class PhongKhamService {
    ArrayList<PhongKham> list = new ArrayList<>();

    public PhongKhamService() {
        list.add(new PhongKham(3, "Phong kham A", "Ha Noi", 345));
        list.add(new PhongKham(5, "Phong kham B", "Thai Nguyen", 456));
        list.add(new PhongKham(9, "Phong kham C", "Tay Nguyen", 789));
    }

    public ArrayList<PhongKham> getAll() {
        return list;
    }

    public PhongKham detail(Integer id) {
        PhongKham phongKham = null;
        for(PhongKham pk: list) {
            if(pk.getId() == id) {
                phongKham = pk;
            }
        }
        return phongKham;
    }
    public void add(PhongKham phongKham) {
        list.add(phongKham);
    }
    public void update(PhongKham phongKham) {
        int indexToUpdate = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == phongKham.getId()) {
                indexToUpdate = i;
            }
        }
        list.set(indexToUpdate, phongKham);
    }
    public void delete(Integer id) {
        int index = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                index = i;
            }
        }
        list.remove(index);
    }

}
