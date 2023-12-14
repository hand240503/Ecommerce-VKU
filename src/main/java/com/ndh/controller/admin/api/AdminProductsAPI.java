package com.ndh.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.model.PageModel;
import com.ndh.paging.PageRequest;
import com.ndh.paging.Pageble;
import com.ndh.service.ICategoryService;
import com.ndh.service.IImageService;
import com.ndh.service.IProductService;
import com.ndh.sorter.Sorter;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin-products")
public class AdminProductsAPI extends HttpServlet {
    @Inject
    private IProductService productService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IImageService imageService;

    public AdminProductsAPI() {
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

        Pageble pageble = new PageRequest(pageModel.getPage(), pageModel.getMaxPageItem(), null, null);

        pageModel.setTotalItem(productService.countProducts());
        pageModel.setTotalPage((int) Math.ceil((double) pageModel.getTotalItem() / pageModel.getMaxPageItem()));

        mapper.writeValue(response.getOutputStream(), productService.findByCategoryCode(pageble));

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
