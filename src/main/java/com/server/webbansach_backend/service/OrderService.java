package com.server.webbansach_backend.service;

import com.server.webbansach_backend.entity.DonHang;
import com.server.webbansach_backend.entity.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    DonHang getOrder(int maDonHang);

    List<Sach> getOrdering();

    List<DonHang> getUserOrderList();

}
