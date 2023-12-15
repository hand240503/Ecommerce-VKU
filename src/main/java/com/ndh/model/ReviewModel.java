package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewModel extends AbstractModel<ReviewModel> {

    private String comment;
    private int idProduct;

}
