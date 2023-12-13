package com.ndh.dao.impl;

import com.ndh.dao.IOrderDetailDAO;
import com.ndh.model.OrderDetailModel;

public class OrderDetailDAO extends AbstractDAO<OrderDetailModel> implements IOrderDetailDAO {
    @Override
    public Long save(OrderDetailModel orderDetailModel) {
        String sql = "INSERT INTO ECOMMERCE_VKU.ta_aut_order_details\n" +
                "(I_ID_ORDER, I_ID_PRODUCT, I_QUANTITY, F_TOTAL_PRICE,  D_CREATED_AT)\n" +
                "VALUES(?, ?, ?, ?, ?);";
        return insert(sql, orderDetailModel.getIdOrder(), orderDetailModel.getIdProduct(), orderDetailModel.getQuantity(), orderDetailModel.getTotalPrice(), orderDetailModel.getCreatedDate());
    }

}
