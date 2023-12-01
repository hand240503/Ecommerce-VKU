package com.ndh.controller.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.model.UserModel;
import com.ndh.service.ICookiesService;
import com.ndh.service.IUserService;
import com.sun.tools.javac.Main;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

@WebServlet("/cart")
public class CartContainer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private IUserService userService;

    @Inject
    private ICookiesService cookieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = cookieService.getCookieValue(req, "jwt-token");
        String cartCookieValue = cookieService.getCookieValue(req, "cart");
        JwtService jwtService = new JwtService();
        if (token != null && jwtService.validateTokenLogin(token)) {

            UserModel userModel = userService.findOneById(jwtService.getIDFromToken(token));
            if (userModel != null) {
                req.setAttribute("user", userModel);
            }

        }

        System.out.println("cart: "+cartCookieValue);

//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(cartCookieValue);
//
//        List<Integer> idList = new ArrayList<>();
//
//        jsonNode.fields().forEachRemaining(entry -> {
//            int id = entry.getValue().get("id").asInt();
//            idList.add(id);
//        });
//
//        System.out.println("List of IDs: " + idList);


        req.getRequestDispatcher("views/web/cart.jsp").forward(req, resp);


    }
}
