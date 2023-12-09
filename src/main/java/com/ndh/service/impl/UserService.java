package com.ndh.service.impl;

import com.ndh.constant.SystemConstant;
import com.ndh.dao.IUserDAO;
import com.ndh.hash.Hashing;
import com.ndh.model.UserModel;
import com.ndh.service.IUserService;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;

    @Inject
    private Hashing hashing;

    @Override
    public UserModel findOneByUsername(String userName) {
        return userDAO.findOneByUsername(userName);
    }

    @Override
    public UserModel login(String userName, String password) {
        UserModel userModel = findOneByUsername(userName);
        try {
            if (!isUserPresent(userModel)) {
                return null;
            }
            if (!isActive(userModel)) {
                return null;
            }
            if (hashing.validatePassword(password, userModel.getHashedPassword())) {
                userModel = userDAO.findOneByUsernameToLogin(userName);
                return userModel;
            }
            return null;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserModel findOneById(Long id) {
        return userDAO.findOneById(id);
    }

    @Override
    public boolean isUserPresent(UserModel userModel) {
        return userModel != null;
    }

    @Override
    public boolean isActive(UserModel userModel) {
        return userModel.getStatus() == SystemConstant.ACTIVE;
    }


    @Override
    public void addUser(UserModel userModel) {
        try {
            String hashPassword = hashing.hashPassWord(userModel.getPassword());
            userModel.setHashedPassword(hashPassword);

            userDAO.addUser(userModel);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updatePassword(int id, String password, String hash) {
        userDAO.updatePassword(id, password, hash);
    }

    @Override
    public List<UserModel> getUserAdmin() {
        return userDAO.getUserAdmin();
    }

    @Override
    public void addOTP(Long id, String otp, int status) {
        userDAO.addOTP(id, otp, status);
    }


}
