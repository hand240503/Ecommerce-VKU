package com.ndh.controller.web;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndh.auth.JwtService;
import com.ndh.constant.SystemConstant;
import com.ndh.model.CategoryModel;
import com.ndh.model.PageModel;
import com.ndh.model.ProductModel;
import com.ndh.model.UserModel;
import com.ndh.paging.PageRequest;
import com.ndh.paging.Pageble;
import com.ndh.sorter.Sorter;
import com.ndh.service.*;
import com.ndh.utils.FormUtil;

@WebServlet("/products")
public class StoreController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IProductService productService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IPageService pageService;

    @Inject
    private IUserService userService;

    @Inject
    private IBrandService brandService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = null;
        Cookie[] cookies = request.getCookies();
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

            UserModel userModel = userService.findOneById(jwtService.getIDFromToken(token));
            if (userModel != null) {
                request.setAttribute("user", userModel);
            }

        }

        PageModel pageModel = FormUtil.toModel(PageModel.class, request);

        String view = "";
        List<CategoryModel> listCategoryModels = categoryService.findAll();

        Sorter sorter = new Sorter();
        String sortName = "";
        String sortBy = "";
        if (pageService.isValidPage(pageModel, listCategoryModels)) {
            if (pageModel.getSortName() != null && pageModel.getSortBy() != null) {

                if (pageModel.getSortName().equals("price-desc")) {
                    sortName = "F_CURRENT_VALUE";
                    sortBy = "DESC";
                    sorter.setSortName(sortName);
                    sorter.setSortBy(sortBy);

                }
                if (pageModel.getSortName().equals("price-asc")) {
                    sortName = "F_CURRENT_VALUE";
                    sortBy = "ASC";
                    sorter.setSortName(sortName);
                    sorter.setSortBy(sortBy);


                }
                if (pageModel.getSortName().equals("new")) {
                    sortName = "product.D_CREATED_AT";
                    sortBy = "DESC";
                    sorter.setSortName(sortName);
                    sorter.setSortBy(sortBy);

                }
            }
            Pageble pageble = new PageRequest(pageModel.getPage(), pageModel.getMaxPageItem(), pageModel.getCode(), sorter);
            request.setAttribute("pageModel", pageModel);
            request.setAttribute("code", pageble.getCode());
            List<ProductModel> productModels = productService.findByCategoryCode(pageble);
            request.setAttribute(SystemConstant.CATEGORY, listCategoryModels);
            request.setAttribute(SystemConstant.PRODUCT, productModels);
            request.setAttribute(SystemConstant.BRAND, brandService.getByCategory(pageble.getCode()));

            view = "views/web/store.jsp";
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        request.getRequestDispatcher(view).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
