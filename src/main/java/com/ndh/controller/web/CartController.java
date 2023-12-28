package com.ndh.controller.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.model.CartModel;
import com.ndh.model.ProductModel;
import com.ndh.model.UserModel;
import com.ndh.service.ICategoryService;
import com.ndh.service.ICookiesService;
import com.ndh.service.IProductService;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private IUserService userService;

    @Inject
    private ICookiesService cookieService;

    @Inject
    private IProductService productService;

    @Inject
    private ICategoryService categoryService;

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

        if (cartCookieValue != null) {
            try {
                byte[] decodedBytes = Base64.getDecoder().decode(cartCookieValue);
                String decodedString = new String(decodedBytes);

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(decodedString);

                List<Integer> idList = new ArrayList<>();
                List<CartModel> cartModelList = new ArrayList<>();

                Map<Integer, Integer> idToQuantityMap = new HashMap<>();

                for (JsonNode userNode : jsonNode) {
                    JsonNode cartItemsArray = userNode.path("cartItems");

                    for (JsonNode cartItem : cartItemsArray) {
                        int itemId = cartItem.path("id").asInt();
                        int quantity = cartItem.path("quantity").asInt();

                        idList.add(itemId);
                        idToQuantityMap.put(itemId, quantity);

                        CartModel cartModel = new CartModel();
                        cartModel.setQuantity(quantity);
                        cartModelList.add(cartModel);
                    }
                }

                List<ProductModel> productModels = productService.getCartProducts(idList);

                for (int i = 0; i < Math.min(productModels.size(), cartModelList.size()); i++) {
                    ProductModel productModel = productModels.get(i);
                    CartModel cartModel = cartModelList.get(i);

                    int itemId = Math.toIntExact(productModel.getId());

                    if (idToQuantityMap.containsKey(itemId)) {
                        int quantity = idToQuantityMap.get(itemId);
                        cartModel.setQuantity(quantity);
                    }

                    cartModel.setId(productModel.getId());
                    cartModel.setUrl(productModel.getImageModel().getPathImageProduct());
                    cartModel.setNameProduct(productModel.getNameProduct());
                    cartModel.setPrice(productModel.getPriceModel().getProductPrice());
                    cartModel.setTotal(productModel.getPriceModel().getProductPrice() * cartModel.getQuantity());

                }
                req.setAttribute(SystemConstant.CATEGORY,categoryService.findAll());
                req.setAttribute(SystemConstant.PRODUCT, cartModelList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        req.getRequestDispatcher("views/web/cart.jsp").forward(req, resp);
    }

}
