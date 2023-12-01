package com.ndh.service.impl;

import com.ndh.dao.IOtpDAO;
import com.ndh.model.OTPModel;
import com.ndh.service.IOtpService;

import javax.inject.Inject;

public class OtpService implements IOtpService {
    @Inject
    private IOtpDAO otpDAO;

    @Override
    public OTPModel getOtp(Long id) {
        return otpDAO.getOTP(id);
    }

    @Override
    public void updateStatus(int id) {
        otpDAO.updateStatus(id);
    }
}
