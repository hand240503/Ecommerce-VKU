package com.ndh.dao.impl;

import com.ndh.dao.IPriceDAO;
import com.ndh.model.PriceModel;

import java.sql.Timestamp;

public class PriceDAO extends AbstractDAO<PriceModel> implements IPriceDAO  {
    @Override
    public Long save(Long idProduct, int idUnit, Double price ) {
        String sql = "INSERT INTO ECOMMERCE_VKU.ta_aut_price\n" +
                "(I_ID_PRODUCT,I_ID_UNIT, F_CURRENT_VALUE, D_CREATED_AT)\n" +
                "VALUES(?,?,?,?);\n";
        return insert(sql,idProduct,1,price,new Timestamp(System.currentTimeMillis()));
    }
}
