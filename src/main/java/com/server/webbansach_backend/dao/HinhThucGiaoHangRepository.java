package com.server.webbansach_backend.dao;



import com.server.webbansach_backend.entity.HinhThucGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucGiaoHangRepository extends JpaRepository<HinhThucGiaoHang,Integer> {
    
}
