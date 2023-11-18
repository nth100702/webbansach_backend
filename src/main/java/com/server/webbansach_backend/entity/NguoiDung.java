package com.server.webbansach_backend.entity;

import lombok.Data;

import javax.management.relation.RoleList;
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

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public char getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(char gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public boolean isDaKichHoat() {
        return daKichHoat;
    }

    public void setDaKichHoat(boolean daKichHoat) {
        this.daKichHoat = daKichHoat;
    }

    public String getMaKichHoat() {
        return maKichHoat;
    }

    public void setMaKichHoat(String maKichHoat) {
        this.maKichHoat = maKichHoat;
    }

    public List<SuDanhGia> getDanhSachDanhGia() {
        return danhSachDanhGia;
    }

    public void setDanhSachDanhGia(List<SuDanhGia> danhSachDanhGia) {
        this.danhSachDanhGia = danhSachDanhGia;
    }

    public List<SachYeuThich> getDanhSachYeuThich() {
        return danhSachYeuThich;
    }

    public void setDanhSachYeuThich(List<SachYeuThich> danhSachYeuThich) {
        this.danhSachYeuThich = danhSachYeuThich;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        System.out.println("Quyền :" + roleList);
        this.roleList = roleList;
    }

    public List<DonHang> getDanhSachDonHang() {
        return danhSachDonHang;
    }

    public void setDanhSachDonHang(List<DonHang> danhSachDonHang) {
        this.danhSachDonHang = danhSachDonHang;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "maNguoiDung=" + maNguoiDung +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChiMuaHang='" + diaChiMuaHang + '\'' +
                ", diaChiGiaoHang='" + diaChiGiaoHang + '\'' +
//                ", daKichHoat=" + daKichHoat +
//                ", maKichHoat='" + maKichHoat + '\'' +
                ", danhSachSuDanhGia=" + danhSachDanhGia +
                ", danhSachSachYeuThich=" + danhSachYeuThich +
                ", danhSachQuyen=" + roleList +
                ", danhSachDonhang=" + danhSachDonHang +
                '}';
    }
}

