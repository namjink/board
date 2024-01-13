package com.lx.board.domain.member.application.port;

import com.lx.board.domain.member.application.port.in.MemberReadCase;
import com.lx.board.domain.member.application.port.in.MemberWriteCase;
import com.lx.board.domain.member.application.port.out.MemberPersistent;
import com.lx.board.domain.member.domain.Member;
import com.lx.board.domain.member.dto.request.*;
import com.lx.board.domain.member.dto.response.GetAllMemberResponse;
import com.lx.board.domain.member.dto.response.CommonMemberResponse;
import com.lx.board.global.exception.BusinessException;
import com.lx.board.global.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements MemberReadCase, MemberWriteCase {

    private final MemberPersistent memberPersistent;


    @Override
    public CommonMemberResponse findMemberBy(String searchBy, String data) {
        throw new BusinessException(ErrorCode.NOT_YET_IMPLEMENTED);
    }

    @Override
    public GetAllMemberResponse findAll() {
        throw new BusinessException(ErrorCode.NOT_YET_IMPLEMENTED);
    }

    @Override
    public CommonMemberResponse signUp(SignUpRequest signUpRequest) {
        Member member = Member.create(signUpRequest.username(), signUpRequest.password(), signUpRequest.nickname());
        member = memberPersistent.save(member);
        return new CommonMemberResponse(member.getId().toString(), member.getUsername(), member.getNickname());
    }

    @Override
    public CommonMemberResponse login(LoginRequest loginRequest) {
        Member member = memberPersistent.findByUsername(loginRequest.username());
        if (member == null || !member.login(loginRequest.password())) throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "회원정보가 존재하지 않거나 정확하지 않습니다.");
        return new CommonMemberResponse(member.getId().toString(), member.getUsername(), member.getNickname());
    }

    @Override
    public void updatePassword(PutPasswordRequest putPasswordRequest) {
        throw new BusinessException(ErrorCode.NOT_YET_IMPLEMENTED);
    }

    @Override
    public CommonMemberResponse updateNickname(PutNicknameRequest putNicknameRequest) {
        throw new BusinessException(ErrorCode.NOT_YET_IMPLEMENTED);
    }

    @Override
    public void deleteMember(DeleteMemberRequest deleteMemberRequest) {
        throw new BusinessException(ErrorCode.NOT_YET_IMPLEMENTED);
    }


}
