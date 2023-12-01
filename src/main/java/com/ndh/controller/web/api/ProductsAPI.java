package com.ndh.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.model.PageModel;
import com.ndh.paging.PageRequest;
import com.ndh.paging.Pageble;
import com.ndh.sorter.Sorter;
import com.ndh.service.ICategoryService;
import com.ndh.service.IImageService;
import com.ndh.service.IProductService;
import com.ndh.utils.HttpUtil;

@WebServlet("/api/products")
public class ProductsAPI extends HttpServlet {
    @Inject
    private IProductService productService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IImageService imageService;

    public ProductsAPI() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PageModel pageModel = HttpUtil.of(request.getReader()).toModel(PageModel.class);

        pageModel.setCode(pageModel.getCode());
        pageModel.setMaxPageItem(pageModel.getMaxPageItem());
        pageModel.setPage(pageModel.getPage());
        Sorter sorter = new Sorter();
        String sortName = "";
        String sortBy = "";
        if (pageModel.getSortName() != null && pageModel.getSortBy() != null) {

            if (pageModel.getSortBy().equals("price-desc")) {
                sortName = "F_CURRENT_VALUE";
                sortBy = "DESC";
                sorter.setSortName(sortName);
                sorter.setSortBy(sortBy);
            }
            if (pageModel.getSortBy().equals("price-asc")) {
                sortName = "F_CURRENT_VALUE";
                sortBy = "ASC";
                sorter.setSortName(sortName);
                sorter.setSortBy(sortBy);

            }
            if (pageModel.getSortBy().equals("new")) {
                sortName = "product.D_CREATED_AT";
                sortBy = "DESC";
                sorter.setSortName(sortName);
                sorter.setSortBy(sortBy);

            }
        }
        if(!pageModel.getBrand().isEmpty() && !pageModel.getBrand().get(0).equals("all")){
            sorter.setBrand(pageModel.getBrand());
        }
        Pageble pageble = new PageRequest(pageModel.getPage(), pageModel.getMaxPageItem(), pageModel.getCode(), sorter);

        pageModel.setTotalItem(productService.getTotalProductPaging(pageModel.getCode()));
        pageModel.setTotalPage((int) Math.ceil((double) pageModel.getTotalItem() / pageModel.getMaxPageItem()));

        mapper.writeValue(response.getOutputStream(), productService.findByCategoryCode(pageble));

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
