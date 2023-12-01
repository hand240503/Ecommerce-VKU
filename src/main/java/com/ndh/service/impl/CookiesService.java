package com.ndh.service.impl;

import com.ndh.service.ICookiesService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookiesService implements ICookiesService {
    @Override
    public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }


}
