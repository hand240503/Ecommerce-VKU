package com.ndh.dao;

import com.ndh.model.OrderModel;

public interface IOrderDAO extends GenericDAO<OrderModel> {
    Long save(OrderModel orderModel);

//    Long save(OrderMo orderModel)''
}
