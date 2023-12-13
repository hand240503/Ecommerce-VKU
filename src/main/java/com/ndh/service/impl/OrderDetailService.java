package com.ndh.service.impl;

import com.ndh.dao.IOrderDetailDAO;
import com.ndh.model.OrderDetailModel;
import com.ndh.service.IOrderDetailService;

import javax.inject.Inject;

public class OrderDetailService implements IOrderDetailService {
    @Inject
    private IOrderDetailDAO orderDetailDAO;

    @Override
    public Long save(OrderDetailModel orderDetailModel) {
        return orderDetailDAO.save(orderDetailModel);
    }
}
