package com.ndh.dao.impl;

import com.ndh.dao.IBrandDAO;
import com.ndh.mapper.BrandMapper;
import com.ndh.model.BrandModel;

import java.util.List;

public class BrandDAO extends AbstractDAO<BrandModel> implements IBrandDAO {
    @Override
    public List<BrandModel> getByCategory(String categoryCode) {
        String sql = "" +
                "SELECT brand.I_ID , brand.T_NAME_BRAND , brand.T_CODE \n" +
                "FROM ta_aut_brand brand\n" +
                "\tINNER JOIN ta_brand_categories \tcabrand \tON brand.I_ID = cabrand.I_ID_BRAND \n" +
                "\tINNER JOIN ta_aut_category \t\tcategory \tON category.I_ID = cabrand.I_ID_CATEGORIES \n" +
                "WHERE category.T_CATEGORY_CODE = ?";
        return query(sql, new BrandMapper(), categoryCode);
    }
}
