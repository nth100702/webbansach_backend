package com.server.webbansach_backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="nguoi_dung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_nguoi_dung")
    private int maNguoiDung;

    @Column(name="ho_dem")
    private String hoDem;

    @Column(name="ten")
    private String ten;

    @Column(name="ten_dang_nhap")
    private String tenDangNhap;

    @Column(name="mat_khau",length = 512)
    private String matKhau;

    @Column(name="gioi_tinh")
    private char gioiTinh;

    @Column(name="email")
    private String email;

    @Column(name="sdt")
    private String soDienThoai;

    @Column(name="dia_chi_mua_hang")
    private String diaChiMuaHang;

    @Column(name="dia_chi_giao_hang")
    private String diaChiGiaoHang;

    @Column(name="da_kich_hoat")
    private boolean daKichHoat;

    @Column(name="ma_kich_hoat")
    private String maKichHoat;

    @OneToMany(mappedBy = "nguoiDung", fetch=FetchType.LAZY, cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<SuDanhGia> danhSachDanhGia;

    @OneToMany(mappedBy = "nguoiDung", fetch=FetchType.LAZY, cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<SachYeuThich> danhSachYeuThich;

    @ManyToMany(fetch=FetchType.EAGER, cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name="nguoidung_quyen",
            joinColumns = @JoinColumn(name="ma_nguoi_dung"),
            inverseJoinColumns =@JoinColumn(name="ma_quyen")
    )
    private List<Role> roleList;

    @OneToMany(mappedBy = "nguoiDung", fetch=FetchType.LAZY, cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<DonHang> danhSachDonHang;
}
