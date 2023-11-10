package com.server.webbansach_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="su_danh_gia")
public class SuDanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_danh_gia")
    private long maDanhGia;

    @Column(name="diem_xep_hang")
    private float rating;

    @Column(name="nhan_xet")
    private String nhanXet;

    @ManyToOne(cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name="ma_nguoi_dung",nullable = false)
    private NguoiDung nguoiDung;


    @ManyToOne(cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name="ma_sach",nullable = false)
    private Sach sach;
}
