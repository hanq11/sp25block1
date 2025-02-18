package com.example.sd20102sof203.buoi13.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Xe {
    private Integer maXe;
    private String tenXe;
    private String hangSanXuat;
    private Float gia;
    private Integer soLuong;
    private String mauSac;
    private String ngayNhap;
    private Boolean isNew;
}
