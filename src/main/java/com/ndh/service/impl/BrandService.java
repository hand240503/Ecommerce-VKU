package com.ndh.service.impl;

import com.ndh.dao.IBrandDAO;
import com.ndh.dao.impl.BrandDAO;
import com.ndh.model.BrandModel;
import com.ndh.service.IBrandService;

import javax.inject.Inject;
import java.util.List;

public class BrandService implements IBrandService {
    @Inject
    private IBrandDAO brandDAO;

    @Override
    public List<BrandModel> getByCategory(String categoryCode) {
        return brandDAO.getByCategory(categoryCode);
    }
}
