package com.ndh.service.impl;

import com.ndh.model.CategoryModel;
import com.ndh.model.PageModel;
import com.ndh.service.ICategoryService;
import com.ndh.service.IPageService;
import com.ndh.service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class PageService implements IPageService {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IProductService productService;

    @Override
    public boolean isValidPage(PageModel pageModel, List<CategoryModel> categoryModels) {
        if (pageModel.getCode() == null || pageModel.getCode().isEmpty()) {
            return false;
        } else {
            categoryModels = categoryService.findAll();
            boolean found = false;

            for (CategoryModel categoryModel : categoryModels) {
                if (categoryModel.getCategoryCode().equals(pageModel.getCode())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                if (pageModel.getPage() <= 0 || pageModel.getPage() == null) {
                    pageModel.setPage(1);
                } else {
                    pageModel.setMaxPageItem(5);
                    pageModel.setTotalItem(productService.getTotalProductPaging(pageModel.getCode()));
                    pageModel.setTotalPage((int) Math.ceil((double) pageModel.getTotalItem() / pageModel.getMaxPageItem()));
                    if (pageModel.getPage() > pageModel.getTotalPage()) {
                        pageModel.setPage(pageModel.getTotalPage());
                    }
                }
            } else {
                return false;
            }

        }
        return true;
    }
}
