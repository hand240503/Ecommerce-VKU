package com.ndh.mapper;

import com.ndh.constant.dbconstant.UserConstant;
import com.ndh.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel userModel = new UserModel();
        try {
            userModel.setId(rs.getLong(UserConstant.I_ID));
            try {
                userModel.setRole(rs.getInt(UserConstant.I_ROLE));
            } catch (Exception e) {

            }
            try {
                userModel.setStatus(rs.getInt(UserConstant.I_STATUS));
            } catch (Exception e) {

            }
            try {
                userModel.setUserName(rs.getString(UserConstant.T_USERNAME));
            } catch (Exception e) {

            }
            try {
                userModel.setFirstName(rs.getString(UserConstant.T_FIST_NAME));
            } catch (Exception e) {

            }
            try {
                userModel.setLastName(rs.getString(UserConstant.T_LAST_NAME));
            } catch (Exception e) {

            }
            try {
                userModel.setPhoneNumber(rs.getString(UserConstant.T_TELEPHONE));
            } catch (Exception e) {

            }
            try {
                userModel.setEmail(rs.getString(UserConstant.T_EMAIL));
            } catch (Exception e) {

            }

            try {
                userModel.setHashedPassword(rs.getString(UserConstant.T_HASHED_PASSWORD));
            } catch (Exception e) {

            }

            try {
                userModel.setCountChangePassword(rs.getInt("I_COUNT_CHANGE_PASS"));
            } catch (Exception e) {
            }
            return userModel;
        } catch (SQLException e) {
            return null;
        }


    }
}
