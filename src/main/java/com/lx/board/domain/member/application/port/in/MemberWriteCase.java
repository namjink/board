package com.lx.board.domain.member.application.port.in;

import com.lx.board.domain.member.dto.request.*;
import com.lx.board.domain.member.dto.response.CommonMemberResponse;

public interface MemberWriteCase {

    CommonMemberResponse signUp(SignUpRequest signUpRequest);

    CommonMemberResponse login(LoginRequest loginRequest);

    void updatePassword(PutPasswordRequest putPasswordRequest);

    CommonMemberResponse updateNickname(PutNicknameRequest putNicknameRequest);

    void deleteMember(DeleteMemberRequest deleteMemberRequest);
}
