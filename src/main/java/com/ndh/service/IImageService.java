package com.ndh.service;

import java.util.List;

import com.ndh.model.ImageModel;

public interface IImageService {

    List<ImageModel> findByIdProduct(int id);

    List<ImageModel> findAll();

    Long save(ImageModel imageModel, Long idProduct);

}
