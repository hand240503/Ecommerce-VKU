package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartModel {
    private Long     id;
    private int     quantity;
    private double  total;
    private String  url;
    private String  nameProduct;
    private double  price;

    @Override
    public String toString() {
        return "CartModel{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", total=" + total +
                ", url='" + url + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
