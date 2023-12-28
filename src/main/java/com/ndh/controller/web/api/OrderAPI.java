package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.model.OrderDetailModel;
import com.ndh.model.OrderModel;
import com.ndh.model.ProductModel;
import com.ndh.service.ICookiesService;
import com.ndh.service.IOrderDetailService;
import com.ndh.service.IOrderService;
import com.ndh.service.IProductService;
import com.ndh.utils.HttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/orders")
public class OrderAPI extends HttpServlet {

    @Inject
    private IOrderService orderService;

    @Inject
    private ICookiesService cookieService;

    @Inject
    private IProductService productService;

    @Inject
    private IOrderDetailService orderDetailService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String jsonData = HttpUtil.of(req.getReader()).getValue();

        JSONObject jsonObject = new JSONObject(jsonData);

        String address_01 = jsonObject.optString("address_01");
        String address_02 = jsonObject.optString("address_02");
        String address_03 = jsonObject.optString("address_03");
        String address_04 = jsonObject.optString("address_04");
        String address_05 = jsonObject.optString("address_05");
        String description = jsonObject.optString("description");
        JSONArray idsArray = jsonObject.optJSONArray("ids");

        List<Map<String, Object>> ids = new ArrayList<>();
        if (idsArray != null) {
            for (int i = 0; i < idsArray.length(); i++) {
                JSONObject idObject = idsArray.optJSONObject(i);
                if (idObject != null) {
                    long id = idObject.optLong("id");
                    int quantity = idObject.optInt("quantity");

                    Map<String, Object> idMap = new HashMap<>();
                    idMap.put("id", id);
                    idMap.put("quantity", quantity);

                    ids.add(idMap);
                }
            }
        }
        List<ProductModel> productModels = new ArrayList<>();
        double total = 0;
        for (Map<String, Object> idMap : ids) {
            Number idNumber = (Number) idMap.get("id");
            int id1 = idNumber.intValue();
            int quantity = (int) idMap.get("quantity");
            ProductModel productModel = productService.findById(id1);
            if (productModel != null) {
                total += productModel.getPriceModel().getProductPrice() * quantity;
            }
        }

        OrderModel orderModel = new OrderModel();
        orderModel.setIdUser(getUser(req));
        orderModel.setDescription(description);
        orderModel.setTotal(total);
        orderModel.setAddress_01(address_01);
        orderModel.setAddress_02(address_02);
        orderModel.setAddress_03(address_03);
        orderModel.setAddress_04(address_04);
        orderModel.setAddress_05(address_05);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        orderModel.setCreatedDate(timestamp);
        Long id = orderService.save(orderModel);
        if (id != 0) {
            for (Map<String, Object> idMap : ids) {
                long idProduct = (long) idMap.get("id");
                Number idNumber = (Number) idMap.get("id");
                int id1 = idNumber.intValue();

                int quantity = (int) idMap.get("quantity");
                ProductModel productModel = productService.findById(id1);
                OrderDetailModel orderDetailModel = new OrderDetailModel();
                orderDetailModel.setIdOrder(id);
                orderDetailModel.setIdProduct(idProduct);
                orderDetailModel.setQuantity(quantity);
                orderDetailModel.setTotalPrice(productModel.getPriceModel().getProductPrice() * quantity);
                orderDetailModel.setCreatedDate(timestamp);

                orderDetailService.save(orderDetailModel);
            }
            mapper.writeValue(resp.getOutputStream(), true);
        }


    }

    private Long getUser(HttpServletRequest req) {
        String token = cookieService.getCookieValue(req, "jwt-token");
        JwtService jwtService = new JwtService();

        return jwtService.getIDFromToken(token);
    }
}
