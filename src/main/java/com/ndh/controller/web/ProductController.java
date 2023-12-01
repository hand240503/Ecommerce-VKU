package com.ndh.controller.web;

import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.dbconstant.ProductConstant;
import com.ndh.model.CategoryModel;
import com.ndh.model.UserModel;
import com.ndh.service.ICategoryService;
import com.ndh.service.IProductService;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IUserService userService;

    @Inject
    private IProductService productService;

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt-token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        JwtService jwtService = new JwtService();
        if (token != null && jwtService.validateTokenLogin(token)) {

            UserModel userModel = userService.findOneById(jwtService.getIDFromToken(token));
            if (userModel != null) {
                req.setAttribute("user", userModel);
            }

        }
        List<CategoryModel> listCategoryModels = categoryService.findAll();

        String pathInfo = req.getPathInfo();
        if (pathInfo != null) {
            try {
                String idParam = pathInfo.substring(1).trim();
                if (idParam != null) {
                    int id = Integer.parseInt(idParam);
                    req.setAttribute(SystemConstant.PRODUCT, productService.findById(id));
                    req.setAttribute(SystemConstant.CATEGORY, listCategoryModels);
                }

            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }

        req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
    }
}
