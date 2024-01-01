package com.ndh.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.constant.SystemConstant;
import com.ndh.model.UserModel;
import com.ndh.service.IUserService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin-users")
public class AdminUserAPI extends HttpServlet {
    @Inject
    private IUserService userService;
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        int status = 1;
        int countChangePassword = 0;
        userModel.setStatus(status);
        userModel.setCountChangePassword(countChangePassword);
        userService.updateStatus(userModel);
        mapper.writeValue(resp.getOutputStream(), true);

    }
}
