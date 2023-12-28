package com.ndh.service.impl;

import com.ndh.dao.IPriceDAO;
import com.ndh.service.IPriceService;

import javax.inject.Inject;

public class PriceService implements IPriceService {

    @Inject
    private IPriceDAO priceDAO;

    @Override
    public void update(int idPrice, int idUnit, Double value) {
        priceDAO.update(idPrice, idUnit, value);
    }

    @Override
    public Long save(Long idProduct, int idUnit, Double price) {
        return priceDAO.save(idProduct, idUnit, price);
    }
}
