package com.ndh.service;

import java.util.List;

import com.ndh.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	
	CategoryModel findByCategoryCode(String categoryModel);

}
