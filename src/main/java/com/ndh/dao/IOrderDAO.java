package com.ndh.dao;

import com.ndh.model.OrderModel;

import java.util.List;

public interface IOrderDAO extends GenericDAO<OrderModel> {
    Long save(OrderModel orderModel);

//    Long save(OrderMo orderModel)''

    List<OrderModel> getUnconfimrOrders();

    List<OrderModel> getConfirmOrders();

    void updateStatusOrders(Long id);

    List<OrderModel> getOrders(Long id);

    void cancelOrder(Long id);

    int countOrders();

    int countProductSell();

    List<OrderModel> getTotalOrders();

    OrderModel getOrder(Long id);
}
