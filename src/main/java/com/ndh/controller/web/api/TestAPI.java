package com.ndh.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndh.service.ICategoryService;
import com.ndh.service.IImageService;
import com.ndh.service.IProductService;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

	public TestAPI() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");




//		Pageble pageble = new PageRequest(pageModel.getPage(), pageModel.getMaxPageItem(), pageModel.getCode(),new Sorter(pageModel.getSortName(),pageModel.getSortBy(),null));

//		mapper.writeValue(response.getOutputStream(), userService.getAllUsers());


	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
