package com.ndh.mapper;

import com.ndh.constant.dbconstant.UnitConstant;
import com.ndh.model.UnitModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitMapper implements RowMapper<UnitModel> {
    @Override
    public UnitModel mapRow(ResultSet rs) {
        UnitModel unitModel = new UnitModel();

        try {
            unitModel.setId(rs.getLong(UnitConstant.I_ID));
            unitModel.setNameUnit(rs.getString(UnitConstant.T_UNIT_NAME));
            return unitModel;

        } catch (SQLException e) {
            return null;
        }
    }
}
