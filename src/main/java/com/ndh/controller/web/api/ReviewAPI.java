package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.model.ReviewModel;
import com.ndh.service.IReviewService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/reviews")
public class ReviewAPI extends HttpServlet {

    @Inject
    private IReviewService reviewService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ReviewModel reviewModel = HttpUtil.of(req.getReader()).toModel(ReviewModel.class);
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
            reviewService.save(reviewModel, id, reviewModel.getIdProduct());
        } else {
            mapper.writeValue(resp.getOutputStream(), false);
        }
    }
}
