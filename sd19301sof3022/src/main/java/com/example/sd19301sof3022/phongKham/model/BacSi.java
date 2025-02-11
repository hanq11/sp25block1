package com.example.sd19301sof3022.phongKham.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bac_si")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "luong")
    private Integer luong;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "id_phong_kham", referencedColumnName = "id")
    private PhongKham phongKham;
}
