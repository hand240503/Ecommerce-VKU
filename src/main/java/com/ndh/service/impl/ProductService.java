package com.ndh.service.impl;

import com.ndh.dao.IImageDAO;
import com.ndh.dao.IProductDAO;
import com.ndh.model.ImageModel;
import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;
import com.ndh.service.IImageService;
import com.ndh.service.IPriceService;
import com.ndh.service.IProductService;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {

    @Inject
    private IProductDAO productDAO;

    @Inject
    private IImageDAO imageDAO;

    @Inject
    private IPriceService priceService;

    @Inject
    private IImageService imageService;

    @Override
    public Long save(ProductModel model, Long idBrand, Long idCategory) {
        return productDAO.save(model, idBrand, idCategory);
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

    @Override
    public int countProducts() {
        return productDAO.countProduct();
    }

    @Override
    public Long insertProduct(ProductModel model, Long idBrand, Long idCategory, int idUnit, double price, ImageModel imageModel) {
        Long idProduct = save(model, idBrand, idCategory);
        priceService.save(idProduct, idUnit, price);
        imageService.save(imageModel, idProduct);
        return idProduct;
    }

    @Override
    public void updateProduct(String nameProduct, String des, int idProduct, int idCategory, int idBrand, int isHot, int isSaleOff, int isNew, int isBestSeller) {
        productDAO.updateProduct(nameProduct, des, idProduct, idCategory, idBrand, isHot, isSaleOff, isNew, isBestSeller);
    }

    @Override
    public void updateStatusProduct(ProductModel productModel) {
        productDAO.updateStatusProduct(productModel);
    }
}
