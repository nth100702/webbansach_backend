package com.server.webbansach_backend.service;


import com.server.webbansach_backend.dto.cart.AddToCartRequest;
import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Sach;

import java.util.List;

public interface CartService {
    List<CartItem> laySachTrongGioHang(NguoiDung nguoiDung);

    void themSachVaoGio(AddToCartRequest addToCartRequest,Sach sach, NguoiDung nguoiDung);

    void xoaSachKhoiGio(int maSach);
}
