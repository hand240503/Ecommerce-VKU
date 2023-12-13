package com.ndh.mapper;

import com.ndh.constant.dbconstant.OrdersConstant;
import com.ndh.model.OrderModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderModel> {
    @Override
    public OrderModel mapRow(ResultSet rs) {
        OrderModel orderModel = new OrderModel();

        try {
            orderModel.setId(rs.getLong(OrdersConstant.I_ID));

            try {
                orderModel.setIdUser(rs.getLong(OrdersConstant.I_ID_USER));
            } catch (Exception e) {

            }

            try {
                orderModel.setType(rs.getInt(OrdersConstant.I_TYPE_ORDER));
            } catch (Exception e) {

            }

            try {
                orderModel.setTotal(rs.getDouble(OrdersConstant.F_TOTAl));
            } catch (Exception e) {

            }

            try {
                orderModel.setDescription(rs.getString(OrdersConstant.T_DESCRIPTION));
            } catch (Exception e) {

            }
            try {
                orderModel.setAddress_01(rs.getString(OrdersConstant.T_ADDRESS_01));
            } catch (Exception e) {

            }
            try {
                orderModel.setAddress_02(rs.getString(OrdersConstant.T_ADDRESS_02));
            } catch (Exception e) {

            }
            try {
                orderModel.setAddress_03(rs.getString(OrdersConstant.T_ADDRESS_03));
            } catch (Exception e) {

            }
            try {
                orderModel.setAddress_04(rs.getString(OrdersConstant.T_ADDRESS_04));
            } catch (Exception e) {

            }
            try {
                orderModel.setCreatedDate(rs.getTimestamp(OrdersConstant.D_CREATED_AT));
            } catch (Exception e) {

            }
            try {
                orderModel.setModifiedDate(rs.getTimestamp(OrdersConstant.D_MODIFIED_AT));
            } catch (Exception e) {

            }

            try {
                orderModel.setAddress_05(rs.getString(OrdersConstant.T_ADDRESS_05));
            }catch (Exception e) {

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderModel;
    }
}
