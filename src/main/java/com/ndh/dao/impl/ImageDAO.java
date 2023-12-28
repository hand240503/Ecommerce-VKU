package com.ndh.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.ndh.dao.IImageDAO;
import com.ndh.mapper.ImageMapper;
import com.ndh.model.ImageModel;

public class ImageDAO extends AbstractDAO<ImageModel> implements IImageDAO {

	@Override
	public List<ImageModel> findByIdProduct(int id) {
		String sql = "SELECT image.T_URL_IMAGE , image.T_DESCRIPTION \r\n"
				+ "FROM ta_aut_product_images image\r\n"
				+ "	INNER JOIN ta_aut_product product on product.I_ID = image.I_ID_PRODUCT \r\n"
				+ "WHERE product.I_ID = ?";
		return query(sql, new ImageMapper(), id);
	}

	@Override
	public List<ImageModel> findAll() {
		String sql = "SELECT image.I_ID_PRODUCT  , image.T_URL_IMAGE , image.T_DESCRIPTION \r\n"
				+ "FROM ta_aut_product_images image\r\n"
				+ "	INNER JOIN ta_aut_product product  ON product.I_ID  = image.I_ID_PRODUCT \r\n"
				+ "ORDER BY image.I_ID_PRODUCT ";
		return query(sql, new ImageMapper());
	}

	@Override
	public Long save(ImageModel imageModel,Long idProduct) {
		String sql = "INSERT INTO ECOMMERCE_VKU.ta_aut_product_images\n" +
				"(I_ID_PRODUCT, T_URL_IMAGE, T_DESCRIPTION, D_CREATED_AT, I_TYPE)\n" +
				"VALUES(?, ?, ?, ?, ?);";
		return insert(sql,idProduct,imageModel.getPathImageProduct(),imageModel.getDesImage(),new Timestamp(System.currentTimeMillis()),1);
	}

}
