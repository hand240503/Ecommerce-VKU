package com.ndh.mapper;

import com.ndh.constant.dbconstant.ReviewsConstant;
import com.ndh.model.ReviewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<ReviewModel> {
    @Override
    public ReviewModel mapRow(ResultSet rs) {
        ReviewModel reviewModel = new ReviewModel();
        try {
            reviewModel.setId(rs.getLong(ReviewsConstant.I_ID));

            try {
                reviewModel.setComment(rs.getString(ReviewsConstant.T_COMMENT));
            } catch (Exception e) {
            }

            try {
                reviewModel.setCreatedDate(rs.getTimestamp(ReviewsConstant.D_CREATED_AT));
            } catch (Exception e) {
            }

            return reviewModel;
        } catch (SQLException e) {
            return null;

        }
    }
}
