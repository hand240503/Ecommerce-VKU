package com.ndh.service;

import com.ndh.model.ReviewModel;

import java.util.List;

public interface IReviewService {

    List<ReviewModel> getReviews(int id);
    Long save(ReviewModel reviewModel, Long idUser, int idProduct);
}
