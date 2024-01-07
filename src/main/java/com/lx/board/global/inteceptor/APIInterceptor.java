package com.lx.board.global.inteceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class APIInterceptor implements HandlerInterceptor {

    public static ThreadLocal<String> loginMember = new ThreadLocal<>();
    @Value("${token.name}")
    private String token;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(request.getCookies() == null)) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(token)) {
                    loginMember.set(cookie.getValue());
                    break;
                }
            }

        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        loginMember.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
