package com.ndh.service.impl;

import com.ndh.dao.IUnitDAO;
import com.ndh.model.UnitModel;
import com.ndh.service.IUnitService;

import javax.inject.Inject;
import java.util.List;

public class UnitService implements IUnitService {

    @Inject
    private IUnitDAO unitDAO;
    @Override
    public List<UnitModel> getUnits() {
        return unitDAO.getAllUnits();
    }
}
