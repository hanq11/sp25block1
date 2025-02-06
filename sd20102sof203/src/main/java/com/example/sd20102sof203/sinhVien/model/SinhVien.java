package com.example.sd20102sof203.sinhVien.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    private Integer id;
    private String ten;
    private Float tuoi;
    private Boolean gioiTinh;
}
