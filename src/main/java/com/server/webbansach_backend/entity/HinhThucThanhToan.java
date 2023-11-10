package com.server.webbansach_backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="hinh_thuc_thanh_toan")
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_hinh_thuc_thanh_toan")
    private int maHinhThucThanhToan;
    @Column(name="ten_hinh_thuc_thanh_toan")
    private String tenHinhThuc;
    @Column(name="mo_ta")
    private String moTa;
    @Column(name="chi_phi_thanh_toan")
    private double chiPhiThanhToan;
    @OneToMany(mappedBy = "hinhThucThanhToan", fetch=FetchType.LAZY, cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<DonHang> danhSachDonHang;
}
