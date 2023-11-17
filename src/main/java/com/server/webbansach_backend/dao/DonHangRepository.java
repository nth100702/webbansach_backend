package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="don-hang")
public interface DonHangRepository extends JpaRepository<DonHang,Integer> {
    
}
