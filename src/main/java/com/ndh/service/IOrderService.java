package com.ndh.service;

import com.ndh.dto.OrderDTO;
import com.ndh.model.OrderModel;

import java.util.List;

public interface IOrderService {
    Long save(OrderModel orderModel);

    List<OrderModel> getUnconfirmOrders();

    List<OrderModel> getConfirmOrders();

    void updateStatusOrders(Long id);

    List<OrderModel> getOrders(Long id);

    List<OrderDTO> getOrderDtos(Long id);

    void cancel(Long id);

    int countOrder();

    int countProductSell();

    double getTotal();

    OrderModel getOrder(Long id);
}
