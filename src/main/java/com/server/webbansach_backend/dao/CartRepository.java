package com.server.webbansach_backend.dao;

import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path="gio-hang")
public interface CartRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findAllByNguoiDung(NguoiDung nguoiDung);

    List<CartItem> findByNguoiDung_MaNguoiDung(@Param("maNguoiDung") int maNguoiDung);

    List<CartItem> findByNguoiDung_TenDangNhap(@Param("tenDangNhap") String tenDangNhap);

    void deleteByNguoiDung(NguoiDung nguoiDung);

    public boolean existsByMaGioHang(Integer maGioHang);
}
