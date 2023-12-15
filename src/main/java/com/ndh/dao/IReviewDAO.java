package com.ndh.dao;

import com.ndh.model.ReviewModel;

import java.util.List;

public interface IReviewDAO extends GenericDAO<ReviewModel> {
    Long save(ReviewModel reviewModel,Long idUser, int idProduct);

    List<ReviewModel> getReviews(int id);
}
