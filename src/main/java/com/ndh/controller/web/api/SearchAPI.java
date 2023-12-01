package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.model.SearchModel;
import com.ndh.service.IProductService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/api/search")
public class SearchAPI extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SearchModel searchModel = HttpUtil.of(req.getReader()).toModel(SearchModel.class);

        mapper.writeValue(resp.getOutputStream(), productService.searchProducts(searchModel.getParam()));

    }
}
