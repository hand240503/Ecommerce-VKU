package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.mail.IMail;
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
import java.util.Random;

@WebServlet("/api/identify/forgotPassword")
public class ForgotPasswordAPI extends HttpServlet {

    @Inject
    private IUserService userService;

    @Inject
    private IMail mail;

    @Inject
    private JwtService jwtService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        userModel = userService.findOneByUsername(userModel.getUserName());
        if (userModel != null) {
            mapper.writeValue(resp.getOutputStream(),true);
            String token = jwtService.generateTokenResetPassword(userModel.getId());
            String resetPasswordURL = "http://localhost:8080"+ req.getContextPath() + "/account/reset/" + userModel.getId() + "/" + token;
            userService.addOTP(userModel.getId(),token, 1);
            mail.sendEmailToGetPassword(userModel.getEmail(), "GET PASSWORD", resetPasswordURL);
        } else {
            mapper.writeValue(resp.getOutputStream(), false);
        }
    }


}
