package com.ndh.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.ndh.dao.IProductDAO;

import com.ndh.mapper.ProductMapper;
import com.ndh.model.ProductModel;
import com.ndh.paging.Pageble;
import com.ndh.service.impl.UUIDService;

import javax.inject.Inject;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    @Inject
    private UUIDService uuidService;

    @Override
    public Long save(ProductModel model, Long idBrand, Long idCategory) {
        String sql = "INSERT INTO ECOMMERCE_VKU.ta_aut_product\n" +
                "(T_NAME_PRODUCT, T_DESCRIPTION, I_ID_BRAND, I_ID_CATEGORY, I_TYPE_01, I_TYPE_02, I_TYPE_03, I_TYPE_04, D_CREATED_AT)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        return insert(sql, model.getNameProduct(), model.getDescription(), idBrand, idCategory,
                model.getIsHot(), model.getIsNew(), model.getIsSaleOff(), model.getIsBestSaler(),
                new Timestamp(System.currentTimeMillis()));
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
                "\tWHERE (image.I_TYPE = 1\n" +
                "\tAND (\n" +
                "\t    SELECT COUNT(*)\n" +
                "\t    FROM ta_aut_product AS subproduct\n" +
                "\t    WHERE subproduct.I_ID_CATEGORY = product.I_ID_CATEGORY\n" +
                "\t      AND subproduct.I_ID <= product.I_ID\n" +
                "\t) <= 10)\n" +
                "AND product.I_STATUS = 1\n" +
                "OR product.I_TYPE_01 = 1\n" +
                "OR product.I_TYPE_02 = 1\n" +
                "OR product.I_TYPE_03 = 1\n" +
                "OR product.I_TYPE_04 = 1\n" +
                "ORDER BY product.D_CREATED_AT DESC;";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<ProductModel> findByCategoryCode(Pageble pageble) {
        String sql = "SELECT product.I_ID, product.T_NAME_PRODUCT, product.T_DESCRIPTION, image.T_URL_IMAGE, image.T_DESCRIPTION, price.F_CURRENT_VALUE, unit.T_UNIT_NAME, category.T_CATEGORY_CODE, category.T_CATEGORY_NAME, product.I_TYPE_01, product.I_TYPE_02, product.I_TYPE_03, product.I_TYPE_04 " +
                "FROM ta_aut_product AS product " +
                "INNER JOIN ta_aut_category AS category ON category.I_ID = product.I_ID_CATEGORY " +
                "INNER JOIN ta_aut_price AS price ON price.I_ID_PRODUCT = product.I_ID " +
                "INNER JOIN ta_aut_unit AS unit ON price.I_ID_UNIT = unit.I_ID " +
                "INNER JOIN ta_aut_product_images AS image ON image.I_ID_PRODUCT = product.I_ID " +
                "INNER JOIN ta_aut_brand AS brand ON brand.I_ID = product.I_ID_BRAND ";

        if (isNotBlank(pageble.getCode())) {
            sql += "WHERE category.T_CATEGORY_CODE = ? AND product.I_STATUS = 1";
        }

        if (pageble.getSorter() != null && pageble.getSorter().getBrand() != null && !pageble.getSorter().getBrand().isEmpty()) {
            if (isNotBlank(pageble.getCode())) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += "brand.T_CODE IN (";
            for (String brand : pageble.getSorter().getBrand()) {
                sql += "'" + brand + "', ";
            }
            sql = sql.substring(0, sql.length() - 2) + ")";
        }

        if (pageble.getSorter() != null && isNotBlank(pageble.getSorter().getSortName()) && isNotBlank(pageble.getSorter().getSortBy())) {
            sql += "\n ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy();
        }

        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql += "\n LIMIT " + pageble.getOffset() + ", " + pageble.getLimit();
        }

        if (isNotBlank(pageble.getCode())) {
            return query(sql, new ProductMapper(), pageble.getCode());
        } else {
            return query(sql, new ProductMapper());
        }
    }


    @Override
    public ProductModel findById(int id) {
        String sql = "SELECT product.I_ID , product.I_ID_CATEGORY , product.I_ID_BRAND , unit.I_ID AS ID_UNIT  , image.I_ID AS IMG_ID , price.I_ID AS PRICE_ID , product.T_NAME_PRODUCT  , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE , unit.T_UNIT_NAME , unit.I_RATIO  , category.T_CATEGORY_CODE , category.T_CATEGORY_NAME , product.I_TYPE_01 , product.I_TYPE_02 , product.I_TYPE_03 , product.I_TYPE_04,product.D_CREATED_AT   \n" +
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
                "WHERE category.T_CATEGORY_CODE = ? AND product.I_STATUS = 1;";
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
                "WHERE product.T_NAME_PRODUCT LIKE ? AND product.I_STATUS = 1\n" +
                "ORDER BY product.D_CREATED_AT DESC\n" +
                "LIMIT 3;";
        return query(sql, new ProductMapper(), params);
    }

    @Override
    public List<ProductModel> getProductToCart(String params) {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT  , product.T_DESCRIPTION , image.T_URL_IMAGE , image.T_DESCRIPTION , price.F_CURRENT_VALUE\n" +
                "\tFROM ta_aut_product AS product\n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS \t\tcategory \tON \tcategory.I_ID \t\t= product.I_ID_CATEGORY \n" +
                "\tINNER JOIN ta_aut_price \t\t\tAS\t \tprice \t\tON \tprice.I_ID_PRODUCT  = product.I_ID \n" +
                "\tINNER JOIN ta_aut_unit \t\t\t\tAS\t\tunit\t\tON \tprice.I_ID_UNIT \t= unit.I_ID \n" +
                "\tINNER JOIN ta_aut_product_images   \tAS   \timage       ON  image.I_ID_PRODUCT  = product.I_ID\n" +
                "WHERE product.I_ID IN( " + params + " ) AND product.I_STATUS = 1";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<ProductModel> getProductAdmin() {
        String sql = "SELECT product.I_ID , product.T_NAME_PRODUCT, product.T_DESCRIPTION  , price.F_CURRENT_VALUE , unit.T_UNIT_NAME ,category.T_CATEGORY_NAME, category.T_CATEGORY_CODE , product.I_TYPE_01 , product.I_TYPE_02 , product.I_TYPE_03 , product.I_TYPE_04  \n" +
                "FROM ta_aut_product AS product\n" +
                "\tINNER JOIN \tta_aut_price \t\t\tAS price \tON \tprice.I_ID_PRODUCT \t\t= \tproduct.I_ID \n" +
                "\tINNER JOIN \tta_aut_unit \t\t\tAS unit\t\tON \tunit.I_ID  \t\t\t\t=\tprice.I_ID_UNIT  \n" +
                "\tINNER JOIN ta_aut_category \t\t\tAS category ON \tcategory .I_ID \t\t\t=\tproduct.I_ID_CATEGORY";
        return query(sql, new ProductMapper());
    }

    @Override
    public int countProduct() {
        String sql = "SELECT COUNT(*)\n" +
                "FROM ta_aut_product \n" +
                "WHERE  ta_aut_product.I_STATUS = 1;";
        return count(sql);
    }

    @Override
    public void updateProduct(String nameProduct, String des, int idProduct, int idCategory, int idBrand, int isHot, int isSaleOff, int isNew, int isBestSeller) {
        String sql = "UPDATE ECOMMERCE_VKU.ta_aut_product\n" +
                "SET T_NAME_PRODUCT=?, T_DESCRIPTION=?, I_ID_BRAND=?, I_ID_CATEGORY=?, I_TYPE_01=?, I_TYPE_02=?, I_TYPE_03=?, I_TYPE_04=?, D_MODIFIED_AT=?\n" +
                "WHERE I_ID=?;\n";
        update(sql, nameProduct, des, idBrand, idCategory, isHot, isSaleOff, isNew, isBestSeller, new Timestamp(System.currentTimeMillis()),idProduct);
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
