package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.model.BrandModel;
import com.ndh.service.IBrandService;
import com.ndh.service.ICategoryService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/category")
public class CategoryAPI extends HttpServlet {

    @Inject
    private IBrandService brandService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String data = HttpUtil.of(req.getReader()).getValue();

        String modifiedString = data.replace("\"", "");
        mapper.writeValue(resp.getOutputStream()    , brandService.getByCategory(modifiedString));


    }
}
