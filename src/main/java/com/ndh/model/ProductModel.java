package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductModel extends AbstractModel<ProductModel> {

    private String nameProduct;

    private String description;

    private CategoryModel category;

    private ImageModel imageModel;

    private PriceModel priceModel;

    private UnitModel unitModel;

    List<CategoryModel> categoryModels;

    List<ImageModel> imageModels;

    private Integer page;

    private int isNew;

    private int isHot;

    private int isBestSaler;

    private int isSaleOff;


}
