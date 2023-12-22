package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.model.OrderModel;
import com.ndh.service.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/test")
public class TestAPI extends HttpServlet {
	@Inject
	private IProductService productService;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private IImageService imageService;

	@Inject
	private IUserService userService;

	@Inject
	private IOrderService orderService;

	public TestAPI() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		List<OrderModel> models = orderService.getOrders(7L);

		mapper.writeValue(response.getOutputStream(), orderService.getOrderDtos(7L));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {





//		Pageble pageble = new PageRequest(pageModel.getPage(), pageModel.getMaxPageItem(), pageModel.getCode(),new Sorter(pageModel.getSortName(),pageModel.getSortBy(),null));



	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
