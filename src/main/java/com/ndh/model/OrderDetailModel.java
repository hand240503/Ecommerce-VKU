package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailModel extends AbstractModel<OrderDetailModel> {

    private Long idOrder;

    private Long idProduct;

    private int quantity;

    private double totalPrice;

    private int status;

    private String description;
}
