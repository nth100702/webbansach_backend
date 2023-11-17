package com.server.webbansach_backend.dao;



import com.server.webbansach_backend.entity.SachYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="sach-yeu-thich")
public interface SachYeuThichRepository extends JpaRepository<SachYeuThich,Integer> {
    
}
