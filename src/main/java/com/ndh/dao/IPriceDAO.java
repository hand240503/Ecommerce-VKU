package com.ndh.dao;

import com.ndh.model.PriceModel;

public interface IPriceDAO extends GenericDAO<PriceModel> {

    Long save(Long idUnit, int idProduct, Double price);
}
