package com.ndh.dao;

import java.util.List;

import com.ndh.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {

	List<CategoryModel> findAll();

	CategoryModel findByCategoryCode(String categoryCode);
}
