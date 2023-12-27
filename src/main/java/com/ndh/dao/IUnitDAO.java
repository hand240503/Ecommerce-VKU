package com.ndh.dao;

import com.ndh.model.UnitModel;

import java.util.List;

public interface IUnitDAO extends GenericDAO<UnitModel> {

    List<UnitModel> getAllUnits();
}
