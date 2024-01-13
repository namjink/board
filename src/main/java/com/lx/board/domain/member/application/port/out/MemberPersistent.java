package com.lx.board.domain.member.application.port.out;

import com.lx.board.domain.member.domain.Member;

import java.util.UUID;

public interface MemberPersistent {

    Member save(Member member);

    Member update(Member member);

    Member findById(UUID id);

    Member findByUsername(String username);
}
