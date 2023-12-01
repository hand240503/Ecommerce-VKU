package com.ndh.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public interface ICookiesService {
    String getCookieValue(HttpServletRequest request, String cookieName);
}
