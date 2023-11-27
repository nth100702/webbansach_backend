package com.server.webbansach_backend.service.impl;


import com.server.webbansach_backend.dao.CartRepository;
import com.server.webbansach_backend.dao.SachRepository;
import com.server.webbansach_backend.dto.cart.AddToCartRequest;
import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Sach;
import com.server.webbansach_backend.service.CartService;
import com.server.webbansach_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final UserService userService;
    private final SachRepository sachRepository;
    private final CartRepository cartRepository;

    @Override
    public List<CartItem> laySachTrongGioHang(NguoiDung nguoiDung) {
//        NguoiDung nguoiDung=userService.getAuthenticatedUser();
//        return  nguoiDung.getDanhSachSach();
        return cartRepository.findAllByNguoiDung(nguoiDung);
    }

    @Override
//    @Transactional
//    public void themSachVaoGio(int maSach) {
//        NguoiDung nguoiDung=userService.getAuthenticatedUser();
//        Sach sach= sachRepository.getById(maSach);
//        nguoiDung.getDanhSachSach().add(sach);
//    }
    public void themSachVaoGio(AddToCartRequest addToCartRequest,Sach sach, NguoiDung nguoiDung){
        CartItem cartItem=new CartItem(addToCartRequest.getSoLuong(),nguoiDung,sach);
        cartRepository.save(cartItem);
    }


    @Override
    @Transactional
    public void xoaSachKhoiGio(int maSach) {
        NguoiDung nguoiDung=userService.getAuthenticatedUser();
        Sach sach=sachRepository.getById(maSach);
        nguoiDung.getDanhSachSach().remove(sach);
    }
}
