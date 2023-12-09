package com.ndh.controller.admin;

import com.ndh.constant.SystemConstant;
import com.ndh.service.IProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-products")
public class AdminProductController extends HttpServlet {

    @Inject
    private IProductService productService;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(SystemConstant.PRODUCT, productService.getProductAdmin());

        req.getRequestDispatcher("views/admin/product.jsp").forward(req, resp);
    }
}
