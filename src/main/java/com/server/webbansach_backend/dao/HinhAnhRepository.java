package com.server.webbansach_backend.dao;



import com.server.webbansach_backend.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="hinh-anh")
public interface HinhAnhRepository extends JpaRepository<HinhAnh,Integer> {
    
}
