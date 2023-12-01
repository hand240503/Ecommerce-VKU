package com.ndh.model;

import com.ndh.service.ICategoryService;
import com.ndh.service.IProductService;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.List;

@Getter
@Setter
public class PageModel {
    @Inject
    private ICategoryService categoryService;

    @Inject
    private IProductService productService;

    private Integer page;
    private Integer maxPageItem;
    private Integer totalPage;
    private Integer totalItem;
    private String code;

    private String sortName;

    private String sortBy;
    private List<String> brand;

}
