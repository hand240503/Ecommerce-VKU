package com.ndh.controller.web;

import com.ndh.auth.JwtService;
import com.ndh.model.UserModel;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private IUserService userService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwt-token".equals(cookie.getName())) {
                        Cookie deleteCookie = new Cookie("jwt-token", "");
                        deleteCookie.setMaxAge(0);
                        deleteCookie.setPath(request.getContextPath());
                        response.addCookie(deleteCookie);
                    }
                }
            }
            response.sendRedirect(request.getContextPath() + "/trang-chu");
        } else if (action != null && action.equals("signup")) {
            request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
        } else if (action != null && action.equals("login")) {
            Cookie[] cookies = request.getCookies();
            JwtService jwtService = new JwtService();
            boolean foundJwtToken = false;

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwt-token".equals(cookie.getName())) {
                        foundJwtToken = true;

                        if (jwtService.isTokenExpired(cookie.getValue())) {
                            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                            return;
                        } else {
                            response.sendRedirect(request.getContextPath() + "/trang-chu");
                            return;
                        }
                    }
                }
            }

            if (!foundJwtToken) {
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
        }


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("rememberMe");
            boolean rememberMeCheck = false;
            if (rememberMe != null && rememberMe.equals("on")) {
                rememberMeCheck = true;
            }
            UserModel userModel = userService.login(userName, password);
            if (userModel != null) {
                JwtService jwtService = new JwtService();
                String token = jwtService.generateTokenLogin(userModel.getUserName(), userModel.getId(), userModel.getRole());
                Cookie jwtCookie = new Cookie("jwt-token", token);
                if (rememberMeCheck) {
                    jwtCookie.setMaxAge(7 * 24 * 60 * 60);
                }
                response.addCookie(jwtCookie);
                response.sendRedirect(request.getContextPath() + "/trang-chu");
            } else {
                request.setAttribute("message", "Thông tin đăng nhập không chính xác");
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
        }

    }

}
