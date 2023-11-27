package com.server.webbansach_backend.controller;


import com.server.webbansach_backend.dao.CartRepository;
import com.server.webbansach_backend.dao.SachRepository;
import com.server.webbansach_backend.dto.cart.AddToCartRequest;
import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Sach;
import com.server.webbansach_backend.service.CartService;

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

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/gio-hang")
public class CartController  {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private SachRepository sachRepository;

    @PostMapping("/them")
    ResponseEntity<?> themVaoGio(@RequestBody AddToCartRequest request){

        try{
            NguoiDung newNguoiDung=new NguoiDung();
            Sach newSach=sachRepository.getById(request.getMaSach());
            cartService.themSachVaoGio(request,newSach,newNguoiDung);
            return ResponseEntity.ok().body("Sản phẩm đã được thêm vào giỏ hàng");
        } catch (Exception e){{
            return ResponseEntity.badRequest().body("Có lỗi xảy ra: "+ e.getMessage());
        }}
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> xoaKhoiGio(@PathVariable Integer id){
        boolean exists=cartRepository.existsById(id);
        if(exists){
            cartRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Đã xoa thành công");
        }
        return ResponseEntity.badRequest().body("Có lỗi xảy ra: ");
    }
}
