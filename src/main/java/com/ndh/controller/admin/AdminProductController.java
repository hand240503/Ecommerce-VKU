package com.ndh.controller.admin;

import com.ndh.constant.SystemConstant;
import com.ndh.model.PageModel;
import com.ndh.paging.PageRequest;
import com.ndh.paging.Pageble;
import com.ndh.service.IProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-products")
public class AdminProductController extends HttpServlet {

    @Inject
    private IProductService productService;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pageParameter = req.getParameter("page");
        int page = 0;
        if (pageParameter == null || pageParameter.isBlank()) {
            page = 1;
        } else {
            try {
                page = Integer.parseInt(pageParameter);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        PageModel pageModel = new PageModel();
        pageModel.setPage(page);
        pageModel.setMaxPageItem(10);
        pageModel.setTotalItem(productService.countProducts());

        pageModel.setTotalPage((int) Math.ceil((double) pageModel.getTotalItem() / pageModel.getMaxPageItem()));

        Pageble pageble = new PageRequest(pageModel.getPage(), pageModel.getMaxPageItem(), null, null);


        req.setAttribute(SystemConstant.PRODUCT, productService.findByCategoryCode(pageble));
        req.setAttribute("pageModel", pageModel);
        req.getRequestDispatcher("views/admin/product.jsp").forward(req, resp);
    }
}
