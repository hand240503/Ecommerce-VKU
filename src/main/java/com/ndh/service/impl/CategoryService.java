package com.ndh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.ndh.dao.ICategoryDAO;
import com.ndh.dao.impl.CategoryDAO;
import com.ndh.model.CategoryModel;
import com.ndh.service.ICategoryService;

public class CategoryService implements ICategoryService {

	private ICategoryDAO categoryDAO = new CategoryDAO();

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public CategoryModel findByCategoryCode(String categoryModel) {
		return categoryDAO.findByCategoryCode(categoryModel);
	}

}
