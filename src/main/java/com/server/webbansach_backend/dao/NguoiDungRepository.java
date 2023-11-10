package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    
}
