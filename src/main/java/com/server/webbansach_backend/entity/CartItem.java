package com.server.webbansach_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="gio_hang")
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_gio_hang")
    private int maGioHang;

    @Column(name="tong_tien")
    private double tongTien;

    @Column(name="so_luong")
    private int soLuong;

    @ManyToOne(targetEntity = NguoiDung.class, fetch = FetchType.EAGER)
    @JoinColumn(name="ma_nguoi_dung",nullable = false)
    private NguoiDung nguoiDung;

    @ManyToOne(cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name="ma_sach",nullable = false)
    private Sach sach;

    public CartItem(int soLuong, NguoiDung nguoiDung, Sach sach) {
        this.soLuong = soLuong;
        this.nguoiDung = nguoiDung;
        this.sach = sach;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "maGioHang=" + maGioHang +
                ", tongTien=" + tongTien +
                ", soLuong=" + soLuong +
                ", nguoiDung=" + nguoiDung +
                ", sach=" + sach.getTenSach() +
                '}';
    }
}
