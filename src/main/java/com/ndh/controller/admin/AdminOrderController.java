package com.ndh.controller.admin;

import com.ndh.constant.SystemConstant;
import com.ndh.service.IOrderService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-orders")
public class AdminOrderController extends HttpServlet {
    @Inject
    private IOrderService orderService;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");

        if( type.equals("unconfirmed")) {
            req.setAttribute(SystemConstant.ORDERS, orderService.getUnconfirmOrders());
            req.getRequestDispatcher("/views/admin/unconfirmed_orders.jsp").forward(req, resp);
        }
        if( type.equals("confirmed")) {
            req.setAttribute(SystemConstant.ORDERS, orderService.getConfirmOrders());
            req.getRequestDispatcher("/views/admin/confirmed_orders.jsp").forward(req, resp);
        }
    }
}

