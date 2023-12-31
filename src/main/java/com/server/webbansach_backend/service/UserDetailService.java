package com.server.webbansach_backend.service;

import com.server.webbansach_backend.entity.NguoiDung;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);

}
