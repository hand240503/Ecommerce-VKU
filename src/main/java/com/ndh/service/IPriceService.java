package com.ndh.service;

import com.ndh.dao.IPriceDAO;

public interface IPriceService {

    Long save(Long idProduct, int idUnit, Double price);

    void update(int idPrice, int idUnit, Double price);
}
