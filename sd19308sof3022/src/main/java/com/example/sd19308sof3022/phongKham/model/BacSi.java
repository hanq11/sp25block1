package com.example.sd19308sof3022.phongKham.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bac_si")
@ToString
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ten khong duoc de trong")
    @Column(name = "ten")
    private String ten;

    @NotNull(message = "Luong khong duoc de trong")
    @Range(min = 0, max = 10, message = "luong chi duoc trong khoang 1 den 10")
    @Column(name = "luong")
    private Integer luong;

    @NotNull(message = "Gioi tinh khong duoc de trong")
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @NotNull(message = "Vui long chon phong kham")
    @ManyToOne
    @JoinColumn(name = "id_phong_kham", referencedColumnName = "id")
    private PhongKham phongKham;
}
