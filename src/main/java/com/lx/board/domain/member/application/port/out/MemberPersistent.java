package com.lx.board.domain.member.application.port.out;

import com.lx.board.domain.member.domain.Member;

public interface MemberPersistent {

    String save(Member member);

    void update(Member member);

    Member findById(String id);

    Member findByUsername(String username);
}
