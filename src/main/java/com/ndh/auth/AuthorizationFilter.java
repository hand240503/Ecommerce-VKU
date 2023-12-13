package com.ndh.auth;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();

        if (url.startsWith("/Ecommerce/admin")) {
            String token = null;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwt-token".equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }

            JwtService jwtService = new JwtService();

            if (token != null && jwtService.validateTokenLogin(token)) {
                int role = jwtService.getROLEFromToken(token);

                if (role == 1) {
                    chain.doFilter(request, response);
                    return;
                } else if (role == 2) {
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                    return;
                }
            }
            response.sendRedirect(request.getContextPath() + "/account?action=login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
