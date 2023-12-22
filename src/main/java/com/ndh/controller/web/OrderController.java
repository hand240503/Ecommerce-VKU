package com.ndh.controller.web;

import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.dao.IOrderDAO;
import com.ndh.model.UserModel;
import com.ndh.service.ICategoryService;
import com.ndh.service.IOrderService;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders")
public class OrderController extends HttpServlet {

    @Inject
    private IOrderService orderService;

    @Inject
    private IUserService userService;

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
            Long id = jwtService.getIDFromToken(token);
            UserModel userModel = userService.findOneById(jwtService.getIDFromToken(token));
            if (userModel != null) {
                req.setAttribute("user", userModel);
            }
            req.setAttribute(SystemConstant.CATEGORY, categoryService.findAll());
            req.setAttribute(SystemConstant.ORDERS, orderService.getOrderDtos(id));
        }

        req.getRequestDispatcher("/views/web/order.jsp").forward(req, resp);
    }
}
