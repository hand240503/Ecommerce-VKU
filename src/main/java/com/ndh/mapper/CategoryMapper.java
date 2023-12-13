package com.ndh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndh.constant.dbconstant.CategoryConstant;
import com.ndh.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			try {
				categoryModel.setId(resultSet.getLong(CategoryConstant.I_ID));
			} catch (Exception e) {
			}

            categoryModel.setCategoryName(resultSet.getString(CategoryConstant.T_CATEGORY_NAME));
			categoryModel.setCategoryCode(resultSet.getString(CategoryConstant.T_CATEGORY_CODE));

			return categoryModel;
		} catch (SQLException e) {
			return null;
		}

	}

}
