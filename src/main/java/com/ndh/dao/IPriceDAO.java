package com.ndh.dao;

import com.ndh.model.PriceModel;

import java.sql.Timestamp;

public interface IPriceDAO extends GenericDAO<PriceModel> {

    Long save(Long idUnit, int idProduct, Double price);

    void update(int idPrice, int idUnit, double value);
}
