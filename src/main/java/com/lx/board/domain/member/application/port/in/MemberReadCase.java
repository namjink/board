package com.lx.board.domain.member.application.port.in;

import com.lx.board.domain.member.dto.response.GetAllMemberResponse;
import com.lx.board.domain.member.dto.response.CommonMemberResponse;

public interface MemberReadCase {

    CommonMemberResponse findMemberBy(String searchBy, String data);

    GetAllMemberResponse findAll();
}
