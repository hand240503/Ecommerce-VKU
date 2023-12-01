package com.ndh.controller.web.api;


import com.ndh.model.UserModel;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.utils.HttpUtil;

@WebServlet("/api/accounts")
public class RegisterAPI extends HttpServlet {

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        userModel =  userService.findOneByUsername(userModel.getUserName());
        if (userModel != null) {
            mapper.writeValue(resp.getOutputStream(), true);
        } else {
            userService.addUser(userModel);
            mapper.writeValue(resp.getOutputStream(), false);
        }

    }
}
