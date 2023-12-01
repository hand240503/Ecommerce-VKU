package com.ndh.service;

import com.ndh.model.OTPModel;

public interface IOtpService {

    OTPModel getOtp(Long id);

    void updateStatus(int id);
}
