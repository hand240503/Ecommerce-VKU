package com.ndh.controller.admin;

import com.ndh.constant.SystemConstant;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-users")
public class AdminUserController extends HttpServlet {
    @Inject
    private IUserService userService;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(SystemConstant.USER, userService.getAllUsers());
        req.getRequestDispatcher("views/admin/user.jsp").forward(req, resp);
    }
}
