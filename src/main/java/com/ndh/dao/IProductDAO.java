package com.ndh.dao;

import java.util.List;

import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;

public interface IProductDAO extends GenericDAO<ProductModel> {

    Long save(ProductModel model);

    void update(ProductModel model);

    List<ProductModel> findAll();

    List<ProductModel> findByCategoryCode(Pageble pageble);

    ProductModel findById(int id);

    int getTotalProductPaging(String categoryCode);

    List<ProductModel> searchProducts(String params);

    List<ProductModel> getProductToCart(String params);

    List<ProductModel> getProductAdmin();

    int countProduct();

}
