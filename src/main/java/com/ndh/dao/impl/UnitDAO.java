package com.ndh.dao.impl;

import com.ndh.dao.IUnitDAO;
import com.ndh.mapper.UnitMapper;
import com.ndh.model.UnitModel;

import java.util.List;

public class UnitDAO extends AbstractDAO<UnitModel> implements IUnitDAO {
    @Override
    public List<UnitModel> getAllUnits() {
        String sql = "SELECT unit.I_ID  , unit.T_UNIT_NAME \n" +
                "FROM ta_aut_unit   AS  unit\n";
        return query(sql,new UnitMapper());
    }
}
