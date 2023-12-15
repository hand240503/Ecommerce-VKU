package com.ndh.dao.impl;

import com.ndh.dao.IReviewDAO;
import com.ndh.mapper.ReviewMapper;
import com.ndh.model.ReviewModel;

import java.sql.Timestamp;
import java.util.List;

public class ReviewDAO extends AbstractDAO<ReviewModel> implements IReviewDAO {
    @Override
    public Long save(ReviewModel reviewModel, Long idUser, int idProduct) {
        String sql = "INSERT INTO ECOMMERCE_VKU.ta_aut_reviews\n" +
                "( T_COMMENT, I_ID_PRODUCT, I_ID_USER, D_CREATE_AT)\n" +
                "VALUES(?,?,?,?);";

        return insert(sql, reviewModel.getComment(), idProduct, idUser, new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public List<ReviewModel> getReviews(int id) {
        String sql = "SELECT review.I_ID , review.T_COMMENT , review.D_CREATE_AT \n" +
                "FROM ta_aut_reviews review\n" +
                "\tINNER JOIN ta_aut_product AS product ON product.I_ID = review.I_ID_PRODUCT \n" +
                "WHERE product.I_ID = ?;";
        return query(sql, new ReviewMapper(), id);
    }
}
