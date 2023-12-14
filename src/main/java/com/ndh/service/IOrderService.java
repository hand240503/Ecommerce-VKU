package com.ndh.service;

import com.ndh.model.OrderModel;

import java.util.List;

public interface IOrderService {
    Long save(OrderModel orderModel);

    List<OrderModel> getUnconfirmOrders();
    List<OrderModel> getConfirmOrders();
}
