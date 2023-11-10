package com.server.webbansach_backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="quyen")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_quyen")
    private int maQuyen;
    @Column(name="ten_quyen")
    private String tenQuyen;

    @ManyToMany(fetch= FetchType.LAZY, cascade={
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name="nguoidung_quyen",
            joinColumns = @JoinColumn(name="ma_quyen"),
            inverseJoinColumns =@JoinColumn(name="ma_nguoi_dung")
    )
    List<NguoiDung> danhSachNguoiDung;
}
