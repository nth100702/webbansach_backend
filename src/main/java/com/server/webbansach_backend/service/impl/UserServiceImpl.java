package com.server.webbansach_backend.service.impl;

import com.server.webbansach_backend.dao.NguoiDungRepository;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.security.UserPrincipal;
import com.server.webbansach_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final NguoiDungRepository nguoiDungRepository;
    @Override
    public NguoiDung getAuthenticatedUser() {
        UserPrincipal principal=(UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return nguoiDungRepository.findByTenDangNhap(principal.getUsername());
    }
}
