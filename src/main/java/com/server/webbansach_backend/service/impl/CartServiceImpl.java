package com.server.webbansach_backend.service.impl;


import com.server.webbansach_backend.dao.CartRepository;
import com.server.webbansach_backend.dao.SachRepository;
import com.server.webbansach_backend.dto.cart.AddToCartRequest;
import com.server.webbansach_backend.dto.cart.CartDto;
import com.server.webbansach_backend.dto.cart.CartItemDto;
import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Sach;
import com.server.webbansach_backend.service.CartService;
import com.server.webbansach_backend.service.UserDetailService;
import com.server.webbansach_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    private final UserService userService;
    private final SachRepository sachRepository;


    @Override
    public void themSachVaoGio(AddToCartRequest addToCartRequest, Sach sach, NguoiDung nguoiDung) {
        CartItem cartItem=new CartItem(addToCartRequest.getSoLuong(), nguoiDung, sach);
        cartRepository.save(cartItem);
    }

    @Override
    public void xoaSachKhoiGio(Integer maGioHang) {
        cartRepository.deleteById(maGioHang);
    }

    @Override
    public CartDto listCartItems(NguoiDung nguoiDung) {

        List<CartItem> cartItemList=cartRepository.findByNguoiDung_MaNguoiDung(nguoiDung.getMaNguoiDung());

        List<CartItemDto> cartItems=new ArrayList<>();
        for(CartItem cart:cartItemList){
            CartItemDto cartItemDto=new CartItemDto(cart);
            cartItems.add(cartItemDto);
        }

        double totalCost=0;
        for(CartItemDto cartItemDto:cartItems){
            totalCost += cartItemDto.getSach().getGiaBan()*cartItemDto.getSoLuong();
        }
        return new CartDto(cartItems,totalCost);
    }
}
