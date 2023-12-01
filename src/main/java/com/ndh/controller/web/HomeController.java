package com.ndh.controller.web;

import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.model.UserModel;
import com.ndh.service.ICategoryService;
import com.ndh.service.IProductService;
import com.ndh.service.IUserService;
import com.ndh.service.impl.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/trang-chu")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private IProductService productService ;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUserService userService;

    public HomeController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = null;
        Cookie[] cookies = request.getCookies();
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
                request.setAttribute("user", userModel);
            }

        }

        request.setAttribute(SystemConstant.CATEGORY, categoryService.findAll());
        request.setAttribute(SystemConstant.PRODUCT,productService.findAll());
        request.getRequestDispatcher("views/web/home.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
