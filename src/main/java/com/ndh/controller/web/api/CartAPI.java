package com.ndh.controller.web.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.service.IProductService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/cart")
public class CartAPI extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        String ids = HttpUtil.of(req.getReader()).getValue();
        List<Integer> productIds = mapper.readValue(ids, new TypeReference<List<Integer>>() {
        });
        mapper.writeValue(resp.getOutputStream(), productService.getCartProducts(productIds));

    }
}
