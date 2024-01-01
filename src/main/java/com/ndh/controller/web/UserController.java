package com.ndh.controller.web;

import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.hash.Hashing;
import com.ndh.model.UserModel;
import com.ndh.service.ICategoryService;
import com.ndh.service.IUserService;
import com.ndh.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")

public class UserController extends HttpServlet {

    @Inject
    private IUserService userService;

    @Inject
    private Hashing hashing;

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("t");
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
        req.setAttribute(SystemConstant.CATEGORY, categoryService.findAll());
        if ("view".equals(type)) {
            req.getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);
        }
        if ("edit".equals(type)) {
            req.getRequestDispatcher("/views/web/editProfile.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        UserModel userModel = FormUtil.toModel(UserModel.class, req);
        if (userModel != null) {
            userService.updateProfile(userModel);
        }
        resp.sendRedirect(req.getContextPath() + "/user?t=view");
    }
}