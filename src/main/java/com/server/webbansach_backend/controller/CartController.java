package com.server.webbansach_backend.controller;


import com.server.webbansach_backend.dao.CartRepository;
import com.server.webbansach_backend.dao.NguoiDungRepository;
import com.server.webbansach_backend.dao.SachRepository;
import com.server.webbansach_backend.dto.cart.AddToCartRequest;
import com.server.webbansach_backend.dto.cart.CartDto;
import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Sach;
import com.server.webbansach_backend.service.CartService;

import com.server.webbansach_backend.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("/gio-hang")
public class CartController  {

    @Autowired
    CartService cartService;

    @Autowired
    NguoiDungRepository nguoiDungRepository;

    @Autowired
    private SachRepository sachRepository;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/them")
    public ResponseEntity<?> themVaoGio(@RequestBody AddToCartRequest request, Principal principal){
        if(principal==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ban can dang nhap");
        }
        String username=principal.getName();
        NguoiDung nguoiDung= nguoiDungRepository.findByTenDangNhap(username);
        Sach sach=sachRepository.findByMaSach(request.getMaSach());
        cartService.themSachVaoGio(request,sach,nguoiDung);
        return ResponseEntity.status(HttpStatus.OK).body("da them sach");
    }


    @DeleteMapping("/xoa/{maGioHang}")
    public ResponseEntity<?> removeFromCart(@PathVariable Integer maGioHang,Principal principal){
        if(principal==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ban can dang nhap");
        }
        String username=principal.getName();
        NguoiDung nguoiDung= nguoiDungRepository.findByTenDangNhap(username);
        boolean existsById=cartRepository.existsByMaGioHang(maGioHang);
        if(existsById){
            cartRepository.deleteById(maGioHang);
            return ResponseEntity.status(HttpStatus.OK).body("Da xoa khoi gio hang");
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("khong tim thay san pham can xoa");
    }
}
