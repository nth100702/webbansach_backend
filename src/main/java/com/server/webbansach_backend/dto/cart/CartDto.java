package com.server.webbansach_backend.dto.cart;

import com.server.webbansach_backend.entity.Sach;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private List<CartItemDto> cartItemDtos;

    private double totalCost;
}
