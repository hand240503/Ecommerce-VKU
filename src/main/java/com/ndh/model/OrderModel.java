package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderModel extends AbstractModel<OrderModel> {

    private Long idUser;
    private int type;
    private double total;
    private String description;
    private String address_01;
    private String address_02;
    private String address_03;
    private String address_04;
    private String address_05;
    private List<Map<String, Object>> ids;
}
