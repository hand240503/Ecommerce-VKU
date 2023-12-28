package com.ndh.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ndh.model.OrderModel;
import com.ndh.service.IOrderService;
import com.ndh.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/api/admin-orders")
public class AdminOrdersAPI extends HttpServlet {

    @Inject
    private IOrderService orderService;
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        OrderModel orderModel = HttpUtil.of(req.getReader()).toModel(OrderModel.class);
        orderModel = orderService.getOrder(orderModel.getId());
        if (orderModel != null && orderModel.getStatus() != 3){
            orderService.updateStatusOrders(orderModel.getId());
        }
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
