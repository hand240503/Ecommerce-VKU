package com.ndh.dao;

import com.ndh.model.UserModel;

import java.util.List;

public interface IUserDAO {

    UserModel findOneByUsername(String userName);

    UserModel findOneByUsernameToLogin(String userName);

    UserModel findOneById(Long id);


    void addUser(UserModel model);

    void addOTP(Long id,String otp, int status);

    void updatePassword(int id,String password, String Hash);

}
