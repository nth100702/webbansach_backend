package com.server.webbansach_backend.dao;


import com.server.webbansach_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="role")
public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Role findByTenQuyen(@Param("tenQuyen") String tenQuyen);
}
