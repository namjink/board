package com.lx.board.domain.member.controller;

import com.lx.board.domain.member.application.port.in.MemberWriteCase;
import com.lx.board.domain.member.dto.request.LoginRequest;
import com.lx.board.domain.member.dto.request.SignUpRequest;
import com.lx.board.domain.member.dto.response.CommonMemberResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberWriteCase memberWriteCase;
    @Value("${token.name}")
    private String token;

    @PostMapping("/signup")
    public CommonMemberResponse signup(@RequestBody SignUpRequest signUpRequest, HttpServletResponse httpResponse) {
        CommonMemberResponse commonMemberResponse = memberWriteCase.signUp(signUpRequest);
        Cookie cookie = bakeCookie(token, commonMemberResponse.id());
        httpResponse.addCookie(cookie);
        return commonMemberResponse;
    }

    @PostMapping("/login")
    public CommonMemberResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse httpResponse) {
        CommonMemberResponse commonMemberResponse = memberWriteCase.login(loginRequest);
        Cookie cookie = bakeCookie(token, commonMemberResponse.id());
        httpResponse.addCookie(cookie);
        return commonMemberResponse;
    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse httpResponse) {
        httpResponse.addCookie(new Cookie(token, null));
    }

    private Cookie bakeCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);
        return cookie;
    }
}
