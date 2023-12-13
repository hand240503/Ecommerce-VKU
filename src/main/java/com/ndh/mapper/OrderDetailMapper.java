package com.ndh.mapper;

import com.ndh.constant.dbconstant.OrdersDetailsConstant;
import com.ndh.model.OrderDetailModel;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDetailMapper implements RowMapper<OrderDetailModel> {
    @Override
    public OrderDetailModel mapRow(ResultSet rs) {
        OrderDetailModel orderDetailModel = new OrderDetailModel();

        try {
            orderDetailModel.setId(rs.getLong(OrdersDetailsConstant.I_ID));

            try {
                orderDetailModel.setIdOrder(rs.getLong(OrdersDetailsConstant.I_ID_ORDER));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setIdProduct(rs.getLong(OrdersDetailsConstant.I_ID_PRODUCT));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setQuantity(rs.getInt(OrdersDetailsConstant.I_QUANTITY));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setTotalPrice(rs.getDouble(OrdersDetailsConstant.F_TOTAL_PRICE));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setStatus(rs.getInt(OrdersDetailsConstant.I_SATUS));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setDescription(rs.getString(OrdersDetailsConstant.T_DESCRIPTION));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setCreatedDate(rs.getTimestamp(OrdersDetailsConstant.D_CREATED_AT));
            } catch (Exception e) {
            }

            try {
                orderDetailModel.setModifiedDate(rs.getTimestamp(OrdersDetailsConstant.D_MODIFIED_AT));
            } catch (Exception e) {
            }

            return orderDetailModel;

        } catch (SQLException e) {
            return null;
        }


    }
}
