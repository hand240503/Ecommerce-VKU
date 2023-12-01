package com.ndh.dao;

import com.ndh.model.OTPModel;

public interface IOtpDAO {
    OTPModel getOTP(Long id);

    void updateStatus(int id);
}
