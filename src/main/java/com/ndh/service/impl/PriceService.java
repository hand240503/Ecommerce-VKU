package com.ndh.service.impl;

import com.ndh.dao.IPriceDAO;
import com.ndh.service.IPriceService;

import javax.inject.Inject;

public class PriceService implements IPriceService {

    @Inject
    private IPriceDAO priceDAO;

    @Override
    public Long save(Long idProduct, int idUnit, Double price) {
        return priceDAO.save(idProduct, idUnit, price);
    }
}
