package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.hash.Hashing;
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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/api/password")
public class ChangePasswordAPI extends HttpServlet {

    @Inject
    private IUserService userService;

    @Inject
    private Hashing hashing;

    @Inject
    JwtService jwtService;

    @Inject
    private IMail mail;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        if (userModel != null) {
            try {
                String password = userModel.getPassword();
                userModel = userService.findOneById(userModel.getId());

                if (hashing.validatePassword(password, userModel.getHashedPassword())) {

                    String token = jwtService.generateTokenResetPassword(userModel.getId());
                    String resetPasswordURL = "http://localhost:8080" + req.getContextPath() + "/account/reset/" + userModel.getId() + "/" + token;
                    userService.addOTP(userModel.getId(), token, 1);
                    mail.sendEmailToGetPassword(userModel.getEmail(), "GET PASSWORD", resetPasswordURL);
                    mapper.writeValue(resp.getOutputStream(), true);
                } else {
                    int count = userModel.getCountChangePassword();
                    int countChange = count + 1;
                    userModel.setCountChangePassword(countChange);
                    if(countChange < 5){
                        userService.updateCountChangePassword(userModel);
                    }else{
                        userModel.setStatus(2);
                        userService.updateStatus(userModel);
                    }
                    mapper.writeValue(resp.getOutputStream(), false);


                }


            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
