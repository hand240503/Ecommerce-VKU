package com.ndh.dao.impl;

import java.util.List;

import com.ndh.dao.ICategoryDAO;
import com.ndh.mapper.CategoryMapper;
import com.ndh.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT category.I_ID , category.T_CATEGORY_NAME , category.T_CATEGORY_CODE \r\n"
				+ "FROM ta_aut_category category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findByCategoryCode(String categoryCode) {
		String sql = "SELECT *\r\n"
				+ "FROM ta_aut_category tac\r\n"
				+ "WHERE tac.T_CATEGORY_CODE = ?";
		List<CategoryModel> models = query(sql, new CategoryMapper(), categoryCode);
		return models.isEmpty() ? null : models.get(0) ;
	}

}
