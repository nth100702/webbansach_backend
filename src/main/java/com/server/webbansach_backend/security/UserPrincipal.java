package com.server.webbansach_backend.security;

import com.server.webbansach_backend.entity.NguoiDung;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data
public class UserPrincipal implements UserDetails {
    private final int id;
    private final String passwordd;
    private final String email;
    private final boolean active;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(NguoiDung nguoiDung){
        String userRole =nguoiDung.getRoleList().iterator().next().toString();
        Set<SimpleGrantedAuthority> authorities= Collections.singleton(new SimpleGrantedAuthority(userRole));
        return new UserPrincipal(nguoiDung.getMaNguoiDung(),nguoiDung.getMatKhau(),nguoiDung.getEmail(),nguoiDung.isDaKichHoat(),authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
