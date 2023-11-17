package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="nguoi-dung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {

    public boolean existsByTenDangNhap(@Param("tenDangNhap") String tenDangNhap);

    public boolean existsByEmail (@Param("email") String email);

    public NguoiDung findByTenDangNhap(@Param("tenDangNhap") String tenDangNhap);
}
