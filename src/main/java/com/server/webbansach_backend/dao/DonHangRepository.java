package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="don-hang")
public interface DonHangRepository extends JpaRepository<DonHang,Integer> {
    DonHang findByMaDonHang(@Param("maDonHang") int maDonHang);

    Optional<DonHang> findByNguoiDung_MaNguoiDung(@Param("maNguoiDung") int maNguoiDung);

}
