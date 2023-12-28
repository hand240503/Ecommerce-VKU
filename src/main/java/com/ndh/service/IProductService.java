package com.ndh.service;

import java.util.List;

import com.ndh.model.ImageModel;
import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;

public interface IProductService {
	//-----------------------------This method only use to get data to homepage-----------------------------
	List<ProductModel> findAll();
	//-----------------------------This method only use to get data to homepage-----------------------------

	Long save(ProductModel model , Long  idCategory,Long idBrand);

	void update(ProductModel model);



	List<ProductModel> findByCategoryCode( Pageble pageble);

	ProductModel findById(int id);
	
	int getTotalProductPaging(String categoryCode);

	List<ProductModel> searchProducts(String params);

	List<ProductModel> getCartProducts(List<Integer> productIds);

	List<ProductModel> getProductAdmin();

	int countProducts();

	Long insertProduct(ProductModel model, Long idBrand,Long idCategory, int idUnit, double price, ImageModel imageModel);

}
