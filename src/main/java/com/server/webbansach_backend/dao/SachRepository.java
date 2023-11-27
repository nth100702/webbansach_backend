package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="sach")
public interface SachRepository extends JpaRepository<Sach,Integer> {
    Page<Sach> findByTenSachContaining(@Param("tenSach") String tenSach, Pageable pageable);
    Page<Sach> findByDanhSachTheLoai_MaTheLoai(@Param("maTheLoai") int maTheLoai,Pageable pageable);
    Page<Sach> findByTenSachContainingAndDanhSachTheLoai_MaTheLoai(@Param("tenSach") String tenSach,@Param("maTheLoai") int maTheLoai,Pageable pageable);
}
