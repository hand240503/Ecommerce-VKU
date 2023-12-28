package com.ndh.dao;

import java.util.List;

import com.ndh.model.ImageModel;

public interface IImageDAO extends GenericDAO<ImageModel> {

    List<ImageModel> findByIdProduct(int id);

    List<ImageModel> findAll();


    Long save(ImageModel imageModel, Long idProduct);

    void update(String url, int id);
}
