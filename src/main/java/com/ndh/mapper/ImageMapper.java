package com.ndh.mapper;

import java.sql.ResultSet;

import com.ndh.dbconstant.ImageConstant;
import com.ndh.model.ImageModel;

public class ImageMapper implements RowMapper<ImageModel> {

	@Override
	public ImageModel mapRow(ResultSet rs) {
		ImageModel model = new ImageModel();
		try {
			model.setIdProduct(rs.getLong(ImageConstant.I_ID_PRODUCT));
			model.setPathImageProduct(rs.getString(ImageConstant.T_URL_IMAGE));
			model.setDesImage(rs.getString(ImageConstant.T_DESCRIPTION));
		} catch (Exception e) {
			
		}
		return model;
	}

}
