package com.ndh.service.impl;

import com.ndh.dao.IImageDAO;
import com.ndh.dao.IProductDAO;
import com.ndh.dao.impl.ImageDAO;
import com.ndh.dao.impl.ProductDAO;
import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;
import com.ndh.service.IProductService;

import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {


    private IProductDAO productDAO = new ProductDAO();


    private IImageDAO imageDAO = new ImageDAO();

    @Override
    public Long save(ProductModel model) {
        return productDAO.save(model);
    }

    @Override
    public void update(ProductModel model) {
        productDAO.update(model);
    }

    @Override
    public List<ProductModel> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<ProductModel> findByCategoryCode(Pageble pageble) {
        return productDAO.findByCategoryCode(pageble);
    }

    @Override
    public ProductModel findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public int getTotalProductPaging(String categoryCode) {
        return productDAO.getTotalProductPaging(categoryCode);
    }

    @Override
    public List<ProductModel> searchProducts(String params) {
        String reParam = "%" + params + "%";
        return productDAO.searchProducts(reParam);
    }

    @Override
    public List<ProductModel> getCartProducts(List<Integer> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            return Collections.emptyList();
        }

        StringBuilder paramBuilder = new StringBuilder();
        for (int i = 0; i < productIds.size(); i++) {
            paramBuilder.append(productIds.get(i));
            if (i < productIds.size() - 1) {
                paramBuilder.append(",");
            }
        }

        String param = paramBuilder.toString();
        return productDAO.getProductToCart(param);
    }

    @Override
    public List<ProductModel> getProductAdmin() {
        return productDAO.getProductAdmin();
    }


}
