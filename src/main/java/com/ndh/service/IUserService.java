package com.ndh.service;

import com.ndh.model.UserModel;

import java.util.List;

public interface IUserService {
    UserModel findOneByUsername(String userName);

    UserModel login(String userName, String password);

    UserModel findOneById(Long id);

    boolean isUserPresent(UserModel userModel);

    boolean isActive(UserModel userModel);


    void addUser(UserModel userModel);

    void addOTP(Long id, String otp, int status);

    void updatePassword(int id, String password, String hash);

    List<UserModel> getAllUsers();

    void updateProfile(UserModel userModel);

    void updateCountChangePassword(UserModel userModel);

    void updateStatus(UserModel userModel);

}
