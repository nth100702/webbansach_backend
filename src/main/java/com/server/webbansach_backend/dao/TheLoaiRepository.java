package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.DonHang;
import com.server.webbansach_backend.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai,Integer> {
    
}
