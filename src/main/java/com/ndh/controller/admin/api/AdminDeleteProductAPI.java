package com.ndh.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.model.ProductModel;
import com.ndh.service.IProductService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin-delete-products")
public class AdminDeleteProductAPI extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        productService.updateStatusProduct(productModel);
        mapper.writeValue(resp.getOutputStream(), true);

    }
}
