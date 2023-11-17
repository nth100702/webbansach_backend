package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.SuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="su-danh-gia")
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia,Integer> {
    
}
