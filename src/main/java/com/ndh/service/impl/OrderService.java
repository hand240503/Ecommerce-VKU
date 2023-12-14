package com.ndh.service.impl;

import com.ndh.dao.IOrderDAO;
import com.ndh.model.OrderModel;
import com.ndh.service.IOrderService;

import javax.inject.Inject;
import java.util.List;

public class OrderService implements IOrderService {
    @Inject
    private IOrderDAO orderDAO;

    @Override
    public Long save(OrderModel orderModel) {
        return orderDAO.save(orderModel);
    }

    @Override
    public List<OrderModel> getUnconfirmOrders() {
        return orderDAO.getUnconfimrOrders();
    }

    @Override
    public List<OrderModel> getConfirmOrders() {
        return orderDAO.getConfirmOrders();
    }
}
