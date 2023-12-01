package com.ndh.service.impl;

import com.ndh.service.IUUIDService;

import java.util.UUID;

public class UUIDService implements IUUIDService {
    @Override
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
