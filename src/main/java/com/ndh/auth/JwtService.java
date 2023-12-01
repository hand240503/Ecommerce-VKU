package com.ndh.auth;

import java.util.Date;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class JwtService {

    public static final String USERNAME = "username";
    public static final String ID = "id";
    public static final String ROLE = "role";

    public String generateTokenLogin(String username, Long id, int role) {
        String token = null;
        try {
            JWSSigner signer = new MACSigner(generateShareSecret());
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(USERNAME, username);
            builder.claim(ID, id);
            builder.claim(ROLE, role);
            builder.expirationTime(generateExpirationDate());

            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

            signedJWT.sign(signer);

            token = signedJWT.serialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return token;
    }

    public String generateTokenResetPassword(Long id) {
        String token = null;
        try {
            JWSSigner signer = new MACSigner(generateShareSecret());
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(ID, id);
            builder.expirationTime(generatePasswordResetTokenExpirationTime());

            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

            signedJWT.sign(signer);

            token = signedJWT.serialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return token;
    }

    public String generateTokenCart() {
        return "";
    }


    private JWTClaimsSet getClaimsFromToken(String token) {
        JWTClaimsSet claims = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(generateShareSecret());
            if (signedJWT.verify(verifier))
                claims = signedJWT.getJWTClaimsSet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return claims;
    }

    private Date generateExpirationDate() {
        int expire_time = 7 * 24 * 60 * 60 * 1000;
        return new Date(System.currentTimeMillis() + expire_time);
    }

    private Date generatePasswordResetTokenExpirationTime() {
        int expire_time = 10 * 60 * 1000; // 10 phút
        return new Date(System.currentTimeMillis() + expire_time);
    }


    private Date getExpirationDateFromToken(String token) {
        Date expiration = null;
        JWTClaimsSet claims = getClaimsFromToken(token);
        if (claims != null) {
            expiration = claims.getExpirationTime();
        }
        return expiration;
    }

    public String getUsernameFromToken(String token) {
        String username = null;
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            username = claims.getStringClaim(USERNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    public String getOTPFromResetPasswordToken(String token) {
        String otp = null;
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            if (claims != null) {
                otp = claims.getStringClaim("otp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }


    public Long getIDFromToken(String token) {
        Long id = null;
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            id = claims.getLongClaim(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getROLEFromToken(String token) {
        int role = 0;
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            role = claims.getIntegerClaim("role");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    private byte[] generateShareSecret() {
        byte[] sharedSecret = new byte[32];
        String secret_key = "11111111111111111111111111111111111111111";
        sharedSecret = secret_key.getBytes();
        return sharedSecret;
    }

    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration != null && expiration.before(new Date());
    }

    public Boolean validateTokenLogin(String token) {
        if (token == null || token.trim().length() == 0) {
            return false;
        }
        String username = getUsernameFromToken(token);
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (isTokenExpired(token)) {
            return false;
        }

        return true;
    }

    public Boolean validateTokenPassword(String token) {
        if (isTokenExpired(token)) {
            return false;
        }
        return true;
    }
}
