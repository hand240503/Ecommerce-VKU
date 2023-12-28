package com.ndh.mapper;

import com.ndh.constant.dbconstant.*;
import com.ndh.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderModel> {
    @Override
    public OrderModel mapRow(ResultSet rs) {
        OrderModel orderModel = new OrderModel();
        UserModel userModel = new UserModel();
        OrderDetailModel orderDetailModel = new OrderDetailModel();
        ProductModel productModel = new ProductModel();
        PriceModel priceModel  =  new PriceModel();
        ImageModel imageModel = new ImageModel();
        BrandModel brandModel = new BrandModel();
        try {
            orderModel.setId(rs.getLong(OrdersConstant.I_ID));

            try {
                orderModel.setIdUser(rs.getLong(OrdersConstant.I_ID_USER));
            } catch (Exception e) {

            }

            try {
                userModel.setFirstName(rs.getString(UserConstant.T_FIST_NAME));
                userModel.setLastName(rs.getString(UserConstant.T_LAST_NAME));
                orderModel.setUserModel(userModel);
            }catch (Exception e) {}

            try {
                productModel.setNameProduct(rs.getString(ProductConstant.T_NAME_PRODUCT));
                productModel.setDescription(rs.getString(BrandConstant.T_NAME_BRAND));
                priceModel.setProductPrice(rs.getDouble(PriceConstant.F_CURRENT_VALUE));
                imageModel.setPathImageProduct(rs.getString(ImageConstant.T_URL_IMAGE));
                brandModel.setNameBrand(rs.getString(BrandConstant.T_NAME_BRAND));

                productModel.setPriceModel(priceModel);
                productModel.setImageModel(imageModel);

                orderDetailModel.setProductModel(productModel);
            }catch (Exception e) {}

            try {
                orderDetailModel.setId(rs.getLong("details.I_ID"));
                orderDetailModel.setQuantity(rs.getInt(OrdersDetailsConstant.I_QUANTITY));
                orderDetailModel.setTotalPrice(rs.getDouble(OrdersDetailsConstant.F_TOTAL_PRICE));
                orderModel.setOrderDetailModel(orderDetailModel);
            }catch (Exception e){}




            try {
                orderModel.setType(rs.getInt(OrdersConstant.I_TYPE_ORDER));
            } catch (Exception e) {

            }

            try {
                orderModel.setTotal(rs.getDouble(OrdersConstant.F_TOTAl));
            } catch (Exception e) {

            }

            try {
                orderModel.setStatus(rs.getInt(OrdersConstant.I_STATUS));
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
