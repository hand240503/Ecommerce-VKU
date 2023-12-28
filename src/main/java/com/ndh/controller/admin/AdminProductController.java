package com.ndh.controller.admin;

import com.ndh.constant.SystemConstant;
import com.ndh.model.CategoryModel;
import com.ndh.model.ImageModel;
import com.ndh.model.PageModel;
import com.ndh.model.ProductModel;
import com.ndh.paging.PageRequest;
import com.ndh.paging.Pageble;
import com.ndh.service.ICategoryService;
import com.ndh.service.IProductService;
import com.ndh.service.IUnitService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@MultipartConfig
@WebServlet("/admin-products")
public class AdminProductController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUnitService unitService;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("t");
        String view = "";
        if (type.isEmpty()) {
            type = "list";
        }
        if (type != null) {
            if (type.equals("list")) {
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
                view = "views/admin/product.jsp";
            }
            if (type.equals("add")) {
                req.setAttribute(SystemConstant.CATEGORY, categoryService.findAll());
                req.setAttribute("unit", unitService.getUnits());
                view = "/views/admin/addProduct.jsp";
            }
            req.getRequestDispatcher(view).forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setCharacterEncoding("UTF-8");
        if (ServletFileUpload.isMultipartContent(request)) {
            try {

                ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                String nameProduct = null;
                String description = null;
                String fileName = null;
                String category = null;
                String brand = null;
                String unit = null;
                String price = null;
                int isBestSeller = 0;
                int isHot = 0;
                int isSaleOff = 0;
                int isNew = 0;
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {

                        String fieldName = fileItem.getFieldName();
                        String fieldValue = fileItem.getString("UTF-8");


                        if ("nameProduct".equals(fieldName)) {
                            nameProduct = fieldValue;
                        } else if ("description".equals(fieldName)) {
                            description = fieldValue;
                        } else if ("category".equals(fieldName)) {
                            category = fieldValue;
                        } else if ("brand".equals(fieldName)) {
                            brand = fieldValue;
                        } else if ("unit".equals(fieldName)) {
                            unit = fieldValue;
                        } else if ("isBestSellerValue".equals(fieldName)) {
                            isBestSeller = Boolean.parseBoolean(fieldValue) ? 1 : 0;
                        } else if ("isHotValue".equals(fieldName)) {
                            isHot = Boolean.parseBoolean(fieldValue) ? 1 : 0;
                        } else if ("isSaleOffValue".equals(fieldName)) {
                            isSaleOff = Boolean.parseBoolean(fieldValue) ? 1 : 0;
                        } else if ("isNewValue".equals(fieldName)) {
                            isNew = Boolean.parseBoolean(fieldValue) ? 1 : 0;
                        } else if ("price".equals(fieldName)) {
                            price = fieldValue;
                        }

                    } else {
                        fileName = fileItem.getName();
                        String uploadPath = "C:\\Users\\ADMIN\\eclipse-workspace\\Ecommerce\\src\\main\\webapp\\template\\web\\images\\demos\\demo-4\\products\\" + fileName;

                        File existingFile = new File(uploadPath);

                        if (existingFile.exists()) {
                            existingFile.delete();
                        }
                        try {
                            fileItem.write(new File(uploadPath));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                Long idCategory = Long.parseLong(category);
                Long idBrand = Long.parseLong(brand);
                int idUnit = Integer.parseInt(unit);

                double priceValue = Double.parseDouble(price);

                ProductModel productModel = new ProductModel();
                productModel.setNameProduct(nameProduct);
                productModel.setDescription(description);

                productModel.setIsNew(isNew);
                productModel.setIsBestSaler(isBestSeller);
                productModel.setIsSaleOff(isSaleOff);
                productModel.setIsHot(isHot);
                ImageModel imageModel = new ImageModel();
                imageModel.setPathImageProduct("/template/web/images/demos/demo-4/products/" + fileName);

                productService.insertProduct(productModel, idBrand, idCategory, idUnit, priceValue, imageModel);
                response.sendRedirect(request.getContextPath() + "/admin-products?t=edit");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("File upload failed!");
            }
        } else {
            response.getWriter().println("Invalid request!");
        }
    }

    private ProductModel createProductModel(String nameProduct, String description, int isNew, int isBestSeller, int isSaleOff, int isHot) {
        ProductModel productModel = new ProductModel();
        productModel.setNameProduct(nameProduct);
        productModel.setDescription(description);
        productModel.setIsNew(isNew);
        productModel.setIsBestSaler(isBestSeller);
        productModel.setIsSaleOff(isSaleOff);
        productModel.setIsHot(isHot);
        return productModel;
    }


}
