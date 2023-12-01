package com.ndh.service;

import com.ndh.dao.impl.BrandDAO;
import com.ndh.mapper.BrandMapper;
import com.ndh.model.BrandModel;

import java.util.List;

public interface IBrandService {
    List<BrandModel> getByCategory(String categoryCode);

}
