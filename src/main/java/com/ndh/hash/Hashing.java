package com.ndh.hash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface Hashing {
    public String hashPassWord(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public boolean validatePassword(String originalPassword , String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
