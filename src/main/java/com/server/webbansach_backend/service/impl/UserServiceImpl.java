package com.server.webbansach_backend.service.impl;

import com.server.webbansach_backend.dao.NguoiDungRepository;
import com.server.webbansach_backend.dao.RoleRepository;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Role;
import com.server.webbansach_backend.security.UserPrincipal;
import com.server.webbansach_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserServiceImpl(NguoiDungRepository nguoiDungRepository, RoleRepository quyenRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
        this.roleRepository = quyenRepository;
    }

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public NguoiDung findByUsername(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap((tenDangNhap));
    }

    @Override
    public NguoiDung getAuthenticatedUser() {
        UserPrincipal principal=(UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return nguoiDungRepository.findByEmail(principal.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nguoiDung=nguoiDungRepository.findByTenDangNhap(username);
        if (nguoiDung == null) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại!");
        }
        return new User(nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau(), rolesToAuthorities(nguoiDung.getRoleList()));
    }
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> quyens) {
        return quyens.stream().map(quyen -> new SimpleGrantedAuthority(quyen.getTenQuyen())).collect(Collectors.toList());
    }
}
