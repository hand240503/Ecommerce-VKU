package com.ndh.model;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
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

    private int status;
    private List<Map<String, Object>> ids;

    private UserModel userModel;

    private OrderDetailModel orderDetailModel;

}
