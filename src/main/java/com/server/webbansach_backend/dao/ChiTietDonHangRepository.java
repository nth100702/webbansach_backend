package com.server.webbansach_backend.dao;

import com.server.webbansach_backend.entity.ChiTietDonHang;
import com.server.webbansach_backend.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="chi-tiet-don-hang")
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang,Integer> {
    Sach findBySach_MaSach(int maSach);
}
