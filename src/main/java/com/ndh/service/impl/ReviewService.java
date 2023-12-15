package com.ndh.service.impl;

import com.ndh.dao.IReviewDAO;
import com.ndh.model.ReviewModel;
import com.ndh.service.IReviewService;

import javax.inject.Inject;
import java.util.List;

public class ReviewService implements IReviewService {

    @Inject
    private IReviewDAO reviewDAO;

    @Override
    public List<ReviewModel> getReviews(int id) {
        return reviewDAO.getReviews(id);
    }

    @Override
    public Long save(ReviewModel reviewModel, Long idUser, int idProduct) {
        return reviewDAO.save(reviewModel, idUser, idProduct);
    }
}
