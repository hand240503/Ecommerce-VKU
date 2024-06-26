package com.ndh.dao.impl;

import com.ndh.dao.IUserDAO;
import com.ndh.mapper.UserMapper;
import com.ndh.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public UserModel findOneByUsername(String userName) {
        String sql = "SELECT tuser.I_ID ,tuser.T_USERNAME , tuser.I_ROLE , tuser.I_STATUS  , tuser.T_HASHED_PASSWORD , tuser.T_FIST_NAME , tuser.T_LAST_NAME , tuser.T_EMAIL ,tuser.I_COUNT_CHANGE_PASS \n" +
                "FROM ta_aut_user tuser\n" +
                "WHERE tuser.T_USERNAME = ?;";
        List<UserModel> userModels = query(sql, new UserMapper(), userName);
        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public UserModel findOneByUsernameToLogin(String userName) {
        String sql = "SELECT tuser.I_ID ,tuser.T_USERNAME , tuser.I_ROLE , tuser.I_STATUS , tuser.T_FIST_NAME , tuser.T_LAST_NAME , tuser.T_EMAIL , tuser.I_COUNT_CHANGE_PASS \n" +
                "FROM ta_aut_user tuser\n" +
                "WHERE tuser.T_USERNAME = ?";
        List<UserModel> userModels = query(sql, new UserMapper(), userName);
        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public UserModel findOneById(Long id) {
        String sql = "SELECT tuser.I_ID ,tuser.T_USERNAME , tuser.I_ROLE , tuser.I_STATUS , tuser.T_FIST_NAME , tuser.T_LAST_NAME , tuser.T_EMAIL , tuser.T_TELEPHONE , tuser.T_HASHED_PASSWORD , tuser.I_COUNT_CHANGE_PASS \n" +
                "FROM ta_aut_user tuser\n" +
                "WHERE tuser.I_ID = ?;";
        List<UserModel> userModels = query(sql, new UserMapper(), id);
        return userModels.isEmpty() ? null : userModels.get(0);
    }


    @Override
    public void addUser(UserModel model) {
        String sql = "INSERT INTO ta_aut_user\n" +
                "(T_USERNAME, T_PASSWORD, I_ROLE, T_EMAIL, T_FIST_NAME, T_LAST_NAME, I_STATUS, T_HASHED_PASSWORD ,I_COUNT_CHANGE_PASS)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        insert(sql, model.getUserName(), model.getPassword(), 2, model.getEmail(), model.getFirstName(), model.getLastName(), 1, model.getHashedPassword(), 0);
    }

    @Override
    public void addOTP(Long id, String otp, int status) {
        String sql = "INSERT INTO ta_user_otp\n" +
                "(I_ID_USER,T_TOKEN,I_STATUS)\n" +
                "VALUES(?,?,?)";
        insert(sql, id, otp, status);

    }

    @Override
    public void updatePassword(int id, String password, String Hash) {
        String sql = "UPDATE ta_aut_user\n" +
                "SET T_PASSWORD= ? , T_HASHED_PASSWORD = ? , I_COUNT_CHANGE_PASS = ? \n" +
                "WHERE I_ID = ?;";
        update(sql, password, Hash, 0, id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        String sql = "SELECT I_ID, T_USERNAME, T_PASSWORD, I_ROLE, T_EMAIL, T_FIST_NAME, T_LAST_NAME, T_TELEPHONE, I_STATUS, T_HASHED_PASSWORD, I_COUNT_CHANGE_PASS , D_CREATED_AT, D_MODIFIED_AT\n" +
                "FROM ecommerce_vku.ta_aut_user;";
        return query(sql, new UserMapper());
    }

    @Override
    public void updateProfile(UserModel userModel) {
        String sql = "UPDATE ECOMMERCE_VKU.ta_aut_user\n" +
                "SET T_EMAIL=?, T_FIST_NAME=?, T_LAST_NAME=?, T_TELEPHONE=?\n" +
                "WHERE I_ID=?;\n";
        update(sql, userModel.getEmail(), userModel.getFirstName(), userModel.getLastName(), userModel.getPhoneNumber(), userModel.getId());
    }

    @Override
    public void updateCountChangePassword(UserModel userModel) {
        String sql = "UPDATE ECOMMERCE_VKU.ta_aut_user\n" +
                "SET  I_COUNT_CHANGE_PASS=?\n" +
                "WHERE I_ID=?;\n";
        update(sql, userModel.getCountChangePassword(), userModel.getId());
    }

    @Override
    public void updateStatus(UserModel userModel) {
        String sql = "UPDATE ECOMMERCE_VKU.ta_aut_user\n" +
                "SET  I_COUNT_CHANGE_PASS=? , I_STATUS = ?\n" +
                "WHERE I_ID=?;\n";
        update(sql,userModel.getCountChangePassword(),userModel.getStatus(),userModel.getId());
    }
}
