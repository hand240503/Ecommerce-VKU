package com.ndh.dao.impl;

import com.ndh.dao.IOtpDAO;
import com.ndh.mapper.OTPMapper;
import com.ndh.model.ImageModel;
import com.ndh.model.OTPModel;

import java.util.List;

public class OtpDAO extends AbstractDAO<ImageModel> implements IOtpDAO {
    @Override
    public OTPModel getOTP(Long id) {
        String sql ="SELECT *\n" +
                "FROM ta_user_otp otp\n" +
                "WHERE otp.I_ID_USER  = ? and otp.I_STATUS = 1\n" +
                "ORDER BY otp.I_ID DESC\n" +
                "LIMIT 1;";
        List<OTPModel> otpModel = query(sql,new OTPMapper(),id);
        return  otpModel.isEmpty() ? null : otpModel.get(0);
    }

    @Override
    public void updateStatus(int     id) {
        String sql ="UPDATE ta_user_otp\n" +
                "SET  I_STATUS=2\n" +
                "WHERE I_ID=?;";
        update(sql,id);
    }
}
