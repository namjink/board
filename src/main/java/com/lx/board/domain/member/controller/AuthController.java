package com.lx.board.domain.member.controller;

import com.lx.board.domain.member.application.port.in.MemberWriteCase;
import com.lx.board.domain.member.dto.request.LoginRequest;
import com.lx.board.domain.member.dto.request.SignUpRequest;
import com.lx.board.domain.member.dto.response.CommonMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberWriteCase memberWriteCase;

    @PostMapping("/signup")
    public CommonMemberResponse signup(@RequestBody SignUpRequest signUpRequest) {
        return memberWriteCase.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public CommonMemberResponse login(@RequestBody LoginRequest loginRequest) {
        return memberWriteCase.login(loginRequest);
    }
}
