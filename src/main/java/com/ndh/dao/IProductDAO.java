package com.ndh.dao;

import java.util.List;

import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;

public interface IProductDAO extends GenericDAO<ProductModel> {

    Long save(ProductModel model, Long idBrand, Long idCategory);

    void update(ProductModel model);

    List<ProductModel> findAll();

    List<ProductModel> findByCategoryCode(Pageble pageble);

    ProductModel findById(int id);

    int getTotalProductPaging(String categoryCode);

    List<ProductModel> searchProducts(String params);

    List<ProductModel> getProductToCart(String params);

    List<ProductModel> getProductAdmin();

    int countProduct();

    void updateProduct(String nameProduct,String des,int idProduct, int idCategory, int idBrand,  int isHot, int isSaleOff, int isNew, int isBestSeller);
}
