package com.ndh.dao;

import com.ndh.model.BrandModel;

import java.util.List;

public interface IBrandDAO extends GenericDAO<BrandModel> {
    List<BrandModel> getByCategory(String categoryCode);
}
