package com.ndh.dao.impl;

import com.ndh.dao.GenericDAO;
import com.ndh.dao.IOrderDAO;
import com.ndh.mapper.OrderMapper;
import com.ndh.model.OrderModel;

import java.util.List;

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

    @Override
    public List<OrderModel> getUnconfimrOrders() {
        String sql = "SELECT \n" +
                "    o.I_ID, \n" +
                "    u.T_FIST_NAME,\n" +
                "    u.T_LAST_NAME,\n" +
                "    o.I_TYPE_ORDER, \n" +
                "    o.F_TOTAL, \n" +
                "    o.I_ORDER_DETAIL_AMOUNT, \n" +
                "    o.T_DESCRIPTION, \n" +
                "    o.T_ADDRESS_01, \n" +
                "    o.T_ADDRESS_02, \n" +
                "    o.T_ADDRESS_03, \n" +
                "    o.T_ADDRESS_04, \n" +
                "    o.T_ADDRESS_05, \n" +
                "    o.I_STATUS, \n" +
                "    o.D_CREATED_AT, \n" +
                "    o.D_MODIFIED_AT\n" +
                "FROM \n" +
                "    ecommerce_vku.ta_aut_orders o\n" +
                "INNER JOIN \n" +
                "    ecommerce_vku.ta_aut_user u ON o.I_ID_USER = u.I_ID\n" +
                "WHERE \n" +
                "    o.I_STATUS = '2';";
        return query(sql, new OrderMapper());
    }

    @Override
    public List<OrderModel> getConfirmOrders() {
        String sql = "SELECT \n" +
                "    o.I_ID, \n" +
                "    u.T_FIST_NAME,\n" +
                "    u.T_LAST_NAME,\n" +
                "    o.I_TYPE_ORDER, \n" +
                "    o.F_TOTAL, \n" +
                "    o.I_ORDER_DETAIL_AMOUNT, \n" +
                "    o.T_DESCRIPTION, \n" +
                "    o.T_ADDRESS_01, \n" +
                "    o.T_ADDRESS_02, \n" +
                "    o.T_ADDRESS_03, \n" +
                "    o.T_ADDRESS_04, \n" +
                "    o.T_ADDRESS_05, \n" +
                "    o.I_STATUS, \n" +
                "    o.D_CREATED_AT, \n" +
                "    o.D_MODIFIED_AT\n" +
                "FROM \n" +
                "    ecommerce_vku.ta_aut_orders o\n" +
                "INNER JOIN \n" +
                "    ecommerce_vku.ta_aut_user u ON o.I_ID_USER = u.I_ID\n" +
                "WHERE \n" +
                "    o.I_STATUS = '1';";
        return query(sql, new OrderMapper());
    }


}
