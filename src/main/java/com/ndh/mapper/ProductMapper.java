package com.ndh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndh.constant.dbconstant.CategoryConstant;
import com.ndh.constant.dbconstant.ImageConstant;
import com.ndh.constant.dbconstant.ProductConstant;
import com.ndh.constant.dbconstant.UnitConstant;
import com.ndh.model.*;

public class ProductMapper implements RowMapper<ProductModel> {

    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        ProductModel model = new ProductModel();
        try {

            model.setId(resultSet.getLong(ProductConstant.I_ID));
            model.setNameProduct(resultSet.getString(ProductConstant.T_NAME_PRODUCT));
            model.setDescription(resultSet.getString(ProductConstant.T_DESCRIPTION));
            try {
                model.setIsHot(resultSet.getInt(ProductConstant.I_TYPE_01));
                model.setIsSaleOff(resultSet.getInt(ProductConstant.I_TYPE_02));
                model.setIsNew(resultSet.getInt(ProductConstant.I_TYPE_03));
                model.setIsBestSaler(resultSet.getInt(ProductConstant.I_TYPE_04));
            } catch (Exception e) {

            }

            try {
                model.setStatus(resultSet.getInt("I_STATUS"));
            }catch (Exception e){}

            try {
                model.setIdBrand(resultSet.getLong(ProductConstant.I_ID_BRAND));
            }catch (Exception e) {}

            try {
                UnitModel unitModel = new UnitModel();
                try {
                    unitModel.setId(resultSet.getLong("ID_UNIT"));
                } catch (Exception e) {
                }
                try {
                    unitModel.setNameUnit(resultSet.getString(UnitConstant.T_UNIT_NAME));
                } catch (Exception e) {
                }
                try {
                    unitModel.setRatio(resultSet.getInt(UnitConstant.I_RATIO));

                } catch (Exception e) {
                }
                model.setUnitModel(unitModel);


            } catch (Exception e) {

            }

            try {
                CategoryModel categoryModel = new CategoryModel();
                try {
                    categoryModel.setId(resultSet.getLong(ProductConstant.I_ID_CATEGORY));
                } catch (Exception e1) {
                }
                categoryModel.setCategoryName(resultSet.getString(CategoryConstant.T_CATEGORY_NAME));
                categoryModel.setCategoryCode(resultSet.getString(CategoryConstant.T_CATEGORY_CODE));


                model.setCategory(categoryModel);
            } catch (Exception e) {

            }


            try {
                ImageModel imageModel = new ImageModel();
                try {
                    imageModel.setId(resultSet.getLong("IMG_ID"));
                } catch (Exception e) {
                }
                imageModel.setPathImageProduct(resultSet.getString(ImageConstant.T_URL_IMAGE));
                imageModel.setDesImage(resultSet.getString(ImageConstant.T_DESCRIPTION));

                model.setImageModel(imageModel);
            } catch (Exception e) {

            }

            try {
                PriceModel priceModel = new PriceModel();
                try {
                    priceModel.setId(resultSet.getLong("PRICE_ID"));
                } catch (Exception e) {
                }
                priceModel.setProductPrice(resultSet.getDouble("F_CURRENT_VALUE"));

                model.setPriceModel(priceModel);
            } catch (Exception e) {
            }

            return model;
        } catch (SQLException e) {

            return null;
        }
    }
}
