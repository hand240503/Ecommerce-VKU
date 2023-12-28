package com.ndh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.ndh.dao.IImageDAO;
import com.ndh.model.ImageModel;
import com.ndh.service.IImageService;

public class ImageService implements IImageService {
    @Inject
    private IImageDAO imageDAO;

    @Override
    public List<ImageModel> findByIdProduct(int id) {
        return imageDAO.findByIdProduct(id);
    }

    @Override
    public List<ImageModel> findAll() {

        return imageDAO.findAll();
    }

    @Override
    public Long save(ImageModel imageModel,Long idProduct) {
        return imageDAO.save(imageModel,idProduct);
    }

}
