package com.server.webbansach_backend.dto.cart;


import com.server.webbansach_backend.entity.CartItem;
import com.server.webbansach_backend.entity.Sach;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Integer id;
    private @NotNull Integer soLuong;
    private @NotNull Sach sach;

    public CartItemDto(CartItem cartItem){
        this.setId(cartItem.getMaGioHang());
        this.setSoLuong(cartItem.getSoLuong());
        this.setSach(cartItem.getSach());
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "id=" + id +
                ", soLuong=" + soLuong +
                ", sach{" +
                    "maSach=" + sach.getMaSach() +
                    "tenSach=" + sach.getTenSach() +
                    "tenTacGia=" + sach.getTenTacGia() +
                    "giaBan=" + sach.getGiaBan() +
                    "trungBinhXepHang=" + sach.getTrungBinhXepHang() +
                '}';
    }
}
