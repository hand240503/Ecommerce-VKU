package com.ndh.controller.admin;

import com.ndh.constant.SystemConstant;
import com.ndh.model.PageModel;
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
                boolean isBestSeller = false;
                boolean isHot = false;
                boolean isSaleOff = false;
                boolean isNew = false;
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {

                        String fieldName = fileItem.getFieldName();
                        String fieldValue = fileItem.getString("UTF-8");
                        ;

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
                            isBestSeller = Boolean.parseBoolean(fieldValue);
                        } else if ("isHotValue".equals(fieldName)) {
                            isHot = Boolean.parseBoolean(fieldValue);
                        } else if ("isSaleOffValue".equals(fieldName)) {
                            isSaleOff = Boolean.parseBoolean(fieldValue);
                        } else if ("isNewValue".equals(fieldName)) {
                            isNew = Boolean.parseBoolean(fieldValue);
                        }
                    } else {
                        fileName = fileItem.getName();
                        String uploadPath = "C:\\Users\\ADMIN\\eclipse-workspace\\Ecommerce\\src\\main\\webapp\\template\\web\\images\\demos\\demo-4\\products\\" + fileName;
                        fileItem.write(new File(uploadPath));
                    }
                }

                System.out.println("Name Product: " + nameProduct);
                System.out.println("Description: " + description);
                System.out.println("Category: " + category);
                System.out.println("Brand: " + brand);
                System.out.println("Unit: " + unit);
                System.out.println("IsBestSeller: " + isBestSeller);
                System.out.println("IsHot: " + isHot);
                System.out.println("IsSaleOff: " + isSaleOff);
                System.out.println("IsNew: " + isNew);

                response.sendRedirect(request.getContextPath() +"/admin-products?t=list");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("File upload failed!");
            }
        } else {
            response.getWriter().println("Invalid request!");
        }


//        String nameProduct = request.getParameter("nameProduct");
//        String description = request.getParameter("description");
//        String price = request.getParameter("price");
//
//        String category = request.getParameter("category");
//        String brand = request.getParameter("brand");
//        String unit = request.getParameter("unit");
//
//        boolean isBestSeller = Boolean.parseBoolean(request.getParameter("isBestSeller"));
//        boolean isNew = Boolean.parseBoolean(request.getParameter("isNew"));
//        boolean isSaleOff = Boolean.parseBoolean(request.getParameter("isSaleOff"));
//        boolean isHot = Boolean.parseBoolean(request.getParameter("isHot"));
//
//        System.out.println("Description: " + description);
//        System.out.println("Price: " + price);
//        System.out.println("Category: " + category);
//        System.out.println("Brand: " + brand);
//        System.out.println("Unit: " + unit);
//        System.out.println("IsBestSeller: " + isBestSeller);
//        System.out.println("IsNew: " + isNew);
//        System.out.println("IsSaleOff: " + isSaleOff);
//        System.out.println("IsHot: " + isHot);
//
//        if (ServletFileUpload.isMultipartContent(request)) {
//
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//
//            try {
//                List<FileItem> items = upload.parseRequest(request);
//
//                if (items != null) {
//                    response.getWriter().write("Number of files uploaded: " + items.size());
//
//                    for (FileItem item : items) {
//                        if (!item.isFormField()) {
//                            String fileName = item.getName();
//
//                            if (fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
//                                String uploadPath = "C:\\Users\\ADMIN\\eclipse-workspace\\Ecommerce\\src\\main\\webapp\\template\\web\\images\\demos\\demo-4\\products\\" + fileName;
//                                File uploadedFile = new File(uploadPath);
//                                item.write(uploadedFile);
//                                response.getWriter().write("File uploaded successfully!");
//                            } else {
//                                response.getWriter().write("Invalid file name!");
//                            }
//                        }
//                    }
//                } else {
//                    response.getWriter().write("No files uploaded!");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();;
//            }
//        } else {
//            response.getWriter().write("No multipart content!");
//        }

    }
}
