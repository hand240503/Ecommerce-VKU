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
        return insert(sql, orderModel.getIdUser(), 2, orderModel.getTotal(), 0, orderModel.getDescription(),
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

    @Override
    public void updateStatusOrders(Long id) {
        String sql = "UPDATE ta_aut_orders \n" +
                "set I_STATUS = '1'\n" +
                "WHERE ta_aut_orders.I_ID = ?;";
        update(sql, id);
    }

    @Override
    public List<OrderModel> getOrders(Long id) {
        String sql = "SELECT orders.I_ID , details .I_ID  , product.T_NAME_PRODUCT , price.F_CURRENT_VALUE , details.I_QUANTITY , brand.T_NAME_BRAND   ,details.F_TOTAL_PRICE , image.T_URL_IMAGE ,  orders.F_TOTAL ,orders.I_STATUS \n" +
                "FROM           ta_aut_orders           AS  orders\n" +
                "   INNER JOIN  ta_aut_order_details    AS  details ON  orders.I_ID             =   details.I_ID_ORDER \n" +
                "   INNER JOIN  ta_aut_product          AS  product ON  details.I_ID_PRODUCT    =   product.I_ID \n" +
                "   INNER JOIN  ta_aut_user             AS  tauser  ON  tauser.I_ID             =   orders.I_ID_USER \n" +
                "   INNER JOIN  ta_aut_price            AS  price   ON  price.I_ID_PRODUCT      =   product.I_ID \n" +
                "   INNER JOIN  ta_aut_brand            AS  brand   ON  brand.I_ID              =   product.I_ID_BRAND \n" +
                "   INNER JOIN  ta_aut_product_images   AS  image   ON  image.I_ID_PRODUCT      =   product.I_ID \n" +
                "WHERE tauser.I_ID = ?  AND image.I_TYPE = 1;\n";
        return query(sql, new OrderMapper(), id);
    }

    @Override
    public void cancelOrder(Long id) {
        String sql = "UPDATE ECOMMERCE_VKU.ta_aut_orders\n" +
                "SET I_STATUS = 3\n" +
                "WHERE I_ID = ?;";
        update(sql, id);
    }
}
