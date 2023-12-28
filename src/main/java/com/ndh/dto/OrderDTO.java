package com.ndh.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private double total;
    private int status;
    private List<OrderDetailDTO> orderDetailDTOs;

}
