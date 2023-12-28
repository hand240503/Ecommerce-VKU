package com.ndh.service.impl;

import com.ndh.dao.IOrderDAO;
import com.ndh.dto.OrderDTO;
import com.ndh.dto.OrderDetailDTO;
import com.ndh.dto.ProductDTO;
import com.ndh.model.OrderModel;
import com.ndh.service.IOrderService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    @Inject
    private IOrderDAO orderDAO;


    public Long save(OrderModel orderModel) {
        return orderDAO.save(orderModel);
    }


    public List<OrderModel> getUnconfirmOrders() {
        return orderDAO.getUnconfimrOrders();
    }


    public List<OrderModel> getConfirmOrders() {
        return orderDAO.getConfirmOrders();
    }


    public void updateStatusOrders(Long id) {
        orderDAO.updateStatusOrders(id);
    }


    public List<OrderDTO> getOrderDtos(Long id) {
        List<OrderModel> models = orderDAO.getOrders(id);
        List<OrderDTO> dtos = new ArrayList<>();

        OrderDTO orderDTO = null;
        Long preId = null;

        for (OrderModel orderModel : models) {
            if (orderDTO == null || !orderModel.getId().equals(preId)) {
                orderDTO = new OrderDTO();
                orderDTO.setId(orderModel.getId());
                orderDTO.setOrderDetailDTOs(new ArrayList<>());

                preId = orderModel.getId();
                dtos.add(orderDTO);
            }

            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

            ProductDTO productDTO = new ProductDTO();
            productDTO.setNameProduct(orderModel.getOrderDetailModel().getProductModel().getNameProduct());
            productDTO.setPrice(orderModel.getOrderDetailModel().getProductModel().getPriceModel().getProductPrice());
            productDTO.setNameBrand(orderModel.getOrderDetailModel().getProductModel().getDescription());
            productDTO.setImagePath(orderModel.getOrderDetailModel().getProductModel().getImageModel().getPathImageProduct());

            orderDetailDTO.setId(orderModel.getOrderDetailModel().getId());
            orderDetailDTO.setQuantity(orderModel.getOrderDetailModel().getQuantity());
            orderDetailDTO.setTotalPrice(orderModel.getOrderDetailModel().getTotalPrice());
            orderDetailDTO.setProductDTO(productDTO);
            orderDTO.setTotal(orderModel.getTotal());
            orderDTO.setStatus(orderModel.getStatus());
            orderDTO.getOrderDetailDTOs().add(orderDetailDTO);
        }

        return dtos;
    }

    @Override
    public void cancel(Long id) {
        orderDAO.cancelOrder(id);
    }

    @Override
    public int countOrder() {
        return orderDAO.countOrders();
    }

    @Override
    public double getTotal() {
        List<OrderModel> models = orderDAO.getTotalOrders();
        double total = 0;
        for (OrderModel model : models) {
            total += model.getTotal();
        }

        return total;
    }

    @Override
    public OrderModel getOrder(Long id) {
        return orderDAO.getOrder(id);
    }

    @Override
    public int countProductSell() {
        return orderDAO.countProductSell();
    }


    @Override
    public List<OrderModel> getOrders(Long id) {
        return orderDAO.getOrders(id);
    }


}
