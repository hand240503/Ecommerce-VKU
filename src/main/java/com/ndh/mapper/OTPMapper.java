package com.ndh.mapper;

import com.ndh.model.OTPModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OTPMapper implements   RowMapper<OTPModel> {
    @Override
    public OTPModel mapRow(ResultSet rs) {
        OTPModel otpModel = new OTPModel();
        try {
            otpModel.setId(rs.getInt("I_ID"));
            otpModel.setIdUser(rs.getLong("I_ID_USER"));
            otpModel.setCode(rs.getString("T_TOKEN"));
            otpModel.setStatus(rs.getInt("I_STATUS"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return otpModel;
    }
}
