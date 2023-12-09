package com.ndh.dao.impl;

import java.util.List;
import java.util.UUID;

import com.ndh.dao.IProductDAO;

import com.ndh.mapper.ProductMapper;
import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{

    @Override
    public Long save(ProductModel model) {
        String sql = "INSERT INTO ta_aut_product\r\n" + "(T_NAME_PRODUCT, T_DESCRIPTION)\r\n" + "VALUES(?, ?);\r\n";
        return insert(sql, model.getNameProduct(), model.getDescription());
    }

    @Override
    public void update(ProductModel model) {
        String sql = "UPDATE ECOMMERCE_VKU.ta_aut_product\r\n" + "SET T_NAME_PRODUCT= ?, T_DESCRIPTION= ? \r\n"
                + "WHERE I_ID= ?;\r\n";

        update(sql, model.getNameProduct(), model.getDescription(), model.getId());

    }

    @Override
    public List<ProductModel> findAll() {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE , unit.T_UNIT_NAME , category.T_CATEGORY_CODE , category.T_CATEGORY_NAME , product.I_TYPE_01 , product.I_TYPE_02 , product.I_TYPE_03 , product.I_TYPE_04  \n" +
                "FROM ta_aut_product AS product\n" +
                "\tINNER JOIN \tta_aut_price \t\t\tAS price \tON \tprice.I_ID_PRODUCT \t\t= \tproduct.I_ID \n" +
                "\tINNER JOIN \tta_aut_unit \t\t\tAS unit\t\tON \tunit.I_ID  \t\t\t\t=\tprice.I_ID_UNIT  \n" +
                "\tINNER JOIN \tta_aut_product_images \tAS image\tON\timage.I_ID_PRODUCT \t\t=\tproduct .I_ID \n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS category ON \tcategory .I_ID \t\t\t=\tproduct.I_ID_CATEGORY \n" +
                "\tWHERE image.I_TYPE = 1\n" +
                "\tAND (\n" +
                "\t    SELECT COUNT(*)\n" +
                "\t    FROM ta_aut_product AS subproduct\n" +
                "\t    WHERE subproduct.I_ID_CATEGORY = product.I_ID_CATEGORY\n" +
                "\t      AND subproduct.I_ID <= product.I_ID\n" +
                "\t) <= 9\n" +
                "ORDER BY product.D_CREATED_AT DESC;";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<ProductModel> findByCategoryCode(Pageble pageble) {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE , unit.T_UNIT_NAME , category.T_CATEGORY_CODE , category.T_CATEGORY_NAME , product.I_TYPE_01 , product.I_TYPE_02 , product.I_TYPE_03 , product.I_TYPE_04 \n" +
                "FROM ta_aut_product AS product\n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS \t\tcategory \tON \tcategory.I_ID \t\t= product.I_ID_CATEGORY \n" +
                "\tINNER JOIN ta_aut_price \t\t\tAS\t \tprice \t\tON \tprice.I_ID_PRODUCT  = product.I_ID \n" +
                "\tINNER JOIN ta_aut_unit \t\t\t\tAS\t\tunit\t\tON \tprice.I_ID_UNIT \t= unit.I_ID \n" +
                "\tINNER JOIN ta_aut_product_images   \tAS   \timage       ON  image.I_ID_PRODUCT  = product.I_ID \n" +
                "\tINNER JOIN ta_aut_brand \t\t\tAS \t\tbrand\t\tON \tbrand.I_ID \t\t\t= product.I_ID_BRAND \n" +
                "WHERE category.T_CATEGORY_CODE = ?";

        if (pageble.getSorter().getBrand() != null && !pageble.getSorter().getBrand().isEmpty()) {
            sql += " AND brand.T_CODE IN (";
            for (String brand : pageble.getSorter().getBrand()) {
                sql += "'" + brand + "', ";
            }

            sql = sql.substring(0, sql.length() - 2) + ")";
        }

        if (pageble.getSorter() != null && isNotBlank(pageble.getSorter().getSortName()) && isNotBlank(pageble.getSorter().getSortBy())) {
            sql += "\n ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy();
        }

        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql += "\n LIMIT " + pageble.getOffset() + " , " + pageble.getLimit();
        }


        return query(sql, new ProductMapper(), pageble.getCode());

    }


    @Override
    public ProductModel findById(int id) {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT  , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE , unit.T_UNIT_NAME , category.T_CATEGORY_CODE , category.T_CATEGORY_NAME , product.I_TYPE_01 , product.I_TYPE_02 , product.I_TYPE_03 , product.I_TYPE_04,product.D_CREATED_AT   \n" +
                "FROM ta_aut_product product \n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS \t\tcategory \tON \tcategory.I_ID \t\t= product.I_ID_CATEGORY \n" +
                "\tINNER JOIN ta_aut_price \t\t\tAS\t \tprice \t\tON \tprice.I_ID_PRODUCT  = product.I_ID \n" +
                "\tINNER JOIN ta_aut_unit \t\t\t\tAS\t\tunit\t\tON \tprice.I_ID_UNIT \t= unit.I_ID \n" +
                "\tINNER JOIN ta_aut_product_images   \tAS   \timage       ON  image.I_ID_PRODUCT  = product.I_ID \n" +
                "WHERE product.I_ID = ?";
        List<ProductModel> model = query(sql, new ProductMapper(), id);
        return model.isEmpty() ? null : model.get(0);
    }

    @Override
    public int getTotalProductPaging(String categoryCode) {
        String sql = "SELECT COUNT(*)\n" +
                "FROM ta_aut_product product\n" +
                "\tINNER JOIN ta_aut_category  AS category ON product.I_ID_Category = category.I_ID \n" +
                "WHERE category.T_CATEGORY_CODE = ?;";
        return count(sql, categoryCode);
    }

    @Override
    public List<ProductModel> searchProducts(String params) {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT  , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE\n" +
                "\tFROM ta_aut_product AS product\n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS \t\tcategory \tON \tcategory.I_ID \t\t= product.I_ID_CATEGORY \n" +
                "\tINNER JOIN ta_aut_price \t\t\tAS\t \tprice \t\tON \tprice.I_ID_PRODUCT  = product.I_ID \n" +
                "\tINNER JOIN ta_aut_unit \t\t\t\tAS\t\tunit\t\tON \tprice.I_ID_UNIT \t= unit.I_ID \n" +
                "\tINNER JOIN ta_aut_product_images   \tAS   \timage       ON  image.I_ID_PRODUCT  = product.I_ID \n" +
                "WHERE product.T_NAME_PRODUCT LIKE ?\n" +
                "ORDER BY product.D_CREATED_AT DESC\n" +
                "LIMIT 3;";
        return query(sql, new ProductMapper(), params);
    }

    @Override
    public List<ProductModel> getProductToCart(String params) {
        String sql ="SELECT product.I_ID , product.T_NAME_PRODUCT  , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE\n" +
                "\tFROM ta_aut_product AS product\n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS \t\tcategory \tON \tcategory.I_ID \t\t= product.I_ID_CATEGORY \n" +
                "\tINNER JOIN ta_aut_price \t\t\tAS\t \tprice \t\tON \tprice.I_ID_PRODUCT  = product.I_ID \n" +
                "\tINNER JOIN ta_aut_unit \t\t\t\tAS\t\tunit\t\tON \tprice.I_ID_UNIT \t= unit.I_ID \n" +
                "\tINNER JOIN ta_aut_product_images   \tAS   \timage       ON  image.I_ID_PRODUCT  = product.I_ID\n" +
                "WHERE product.I_ID IN( " + params + " )";
        return query(sql,new ProductMapper());
    }

    @Override
    public List<ProductModel> getProductAdmin() {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT, product.T_DESCRIPTION  x    , price.F_CURRENT_VALUE , unit.T_UNIT_NAME , unit.I_RATIO  ,category.T_CATEGORY_NAME, category.T_CATEGORY_CODE , product.I_TYPE_01 , product.I_TYPE_02 , product.I_TYPE_03 , product.I_TYPE_04  \n" +
                "FROM ta_aut_product AS product\n" +
                "\tINNER JOIN \tta_aut_price \t\t\tAS price \tON \tprice.I_ID_PRODUCT \t\t= \tproduct.I_ID \n" +
                "\tINNER JOIN \tta_aut_unit \t\t\tAS unit\t\tON \tunit.I_ID  \t\t\t\t=\tprice.I_ID_UNIT  \n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS category ON \tcategory .I_ID \t\t\t=\tproduct.I_ID_CATEGORY";
        return query(sql,new ProductMapper());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
