package com.ndh.controller.web;

import com.ndh.auth.JwtService;
import com.ndh.hash.Hashing;
import com.ndh.model.OTPModel;
import com.ndh.service.IOtpService;
import com.ndh.service.IUserService;
import com.ndh.service.impl.OtpService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/account/reset/*")
public class OTPController extends HttpServlet {

    @Inject
    private IOtpService otpService;
    @Inject
    private Hashing hashing;
    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo != null) {
            String[] parts = pathInfo.split("/");

            if (parts.length >= 3) {

                String token = parts[parts.length - 1];
                JwtService jwtService = new JwtService();
                Long iduser = jwtService.getIDFromToken(token);
                OTPModel otpModel = otpService.getOtp(iduser);
                if (!jwtService.isTokenExpired(token)) {
                    if (token.equals(otpModel.getCode()) && otpModel.getStatus() == 1) {
                        req.setAttribute("idUser", iduser);
                        req.getRequestDispatcher("/views/identify/newPassword.jsp").forward(req, resp);
                    }else{
                        resp.sendRedirect(req.getContextPath() + "/account?action=login");
                    }
                } else {
                    resp.sendRedirect(req.getContextPath() + "/account?action=login");
                }
            }
        } else {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("PathInfo is missing");
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        int idUser = Integer.parseInt(req.getParameter("userId"));
        try {
            userService.updatePassword(idUser, password, hashing.hashPassWord(password));
            otpService.updateStatus(idUser);
            resp.sendRedirect(req.getContextPath() + "/account?action=login");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }


    }
}
