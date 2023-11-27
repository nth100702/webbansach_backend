package com.server.webbansach_backend.service.impl;


import com.server.webbansach_backend.dao.DonHangRepository;
import com.server.webbansach_backend.dao.NguoiDungRepository;
import com.server.webbansach_backend.entity.DonHang;
import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Sach;
import com.server.webbansach_backend.service.OrderService;
import com.server.webbansach_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    public OrderServiceImpl(UserService userService, DonHangRepository donHangRepository) {
        this.userService = userService;
        this.donHangRepository = donHangRepository;
    }

    @Override
    public DonHang getOrder(int maDonHang) {
        NguoiDung nguoiDung=userService.getAuthenticatedUser();
//        return donHangRepository.findByMaDonHangAndMaNguoiDung(maDonHang, nguoiDung.getMaNguoiDung())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"order not found"));
        return nguoiDungRepository.findByDanhSachDonHang_MaDonHang(maDonHang)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"order not found"));
    }

    @Override
    public List<Sach> getOrdering() {
        NguoiDung nguoiDung=userService.getAuthenticatedUser();
        return nguoiDung.getDanhSachSach();
    }

    @Override
    public List<DonHang> getUserOrderList() {
        NguoiDung nguoiDung=userService.getAuthenticatedUser();
//        return donHangRepository.findDonHangByMaNguoiDung(nguoiDung.getMaNguoiDung(),pageable);
        return nguoiDung.getDanhSachDonHang();
    }
}
