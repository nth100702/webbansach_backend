package com.server.webbansach_backend.dto.cart;


import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequest {
    private Integer id;
    private @NotNull int maSach;
    private @NotNull int soLuong;

    @Override
    public String toString() {
        return "AddToCartRequest{" +
                "id=" + id +
                ", maSach=" + maSach +
                ", soLuong=" + soLuong +
                '}';
    }
}
