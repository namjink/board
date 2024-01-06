package com.lx.board.domain.member.dto.response;

import java.util.List;

public record GetAllMemberResponse(List<CommonMemberResponse> memberResponseList, Long totalCount) {
}
