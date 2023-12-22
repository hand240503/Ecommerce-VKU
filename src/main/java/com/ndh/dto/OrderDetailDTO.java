package com.ndh.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private Long id;
    private int quantity;
    private double totalPrice;
    private ProductDTO productDTO;

}
