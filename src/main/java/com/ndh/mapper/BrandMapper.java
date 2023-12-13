package com.ndh.mapper;

import com.ndh.constant.dbconstant.BrandConstant;
import com.ndh.model.BrandModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapper implements RowMapper<BrandModel> {
    @Override
    public BrandModel mapRow(ResultSet rs) {
        try {
            BrandModel brandModel = new BrandModel();
            brandModel.setId(rs.getLong(BrandConstant.I_ID));
            brandModel.setNameBrand(rs.getString(BrandConstant.T_NAME_BRAND));
            brandModel.setCodeBrand(rs.getString(BrandConstant.T_CODE));

            return brandModel;
        } catch (SQLException e) {
            return null;
        }

    }
}
