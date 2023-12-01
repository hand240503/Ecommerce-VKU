package com.ndh.service;

import com.ndh.model.CategoryModel;
import com.ndh.model.PageModel;

import java.util.List;

public interface IPageService {
    boolean isValidPage(PageModel pageModel , List<CategoryModel> categoryModels);
}
