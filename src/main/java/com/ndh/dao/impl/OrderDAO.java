package com.ndh.dao.impl;

import com.ndh.dao.GenericDAO;
import com.ndh.dao.IOrderDAO;
import com.ndh.model.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO {
    @Override
    public Long save(OrderModel orderModel) {
        String sql = "INSERT INTO ECOMMERCE_VKU.ta_aut_orders\n" +
                "(I_ID_USER, I_TYPE_ORDER, F_TOTAL, I_ORDER_DETAIL_AMOUNT, T_DESCRIPTION, T_ADDRESS_01, T_ADDRESS_02, T_ADDRESS_03, T_ADDRESS_04, T_ADDRESS_05, I_STATUS, D_CREATED_AT)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\n";

        return insert(sql, orderModel.getIdUser(), 2, orderModel.getTotal(), 0, "",
                orderModel.getAddress_01(), orderModel.getAddress_02(), orderModel.getAddress_03(),
                orderModel.getAddress_04(), orderModel.getAddress_05(), 2, orderModel.getCreatedDate());
    }

}
