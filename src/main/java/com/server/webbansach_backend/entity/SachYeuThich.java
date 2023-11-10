package com.server.webbansach_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="sach_yeu_thich")
public class SachYeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_sach_yeu_thich")
    private int maYeuThich;

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
