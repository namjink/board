package com.lx.board.domain.member.repository;

import com.lx.board.domain.member.application.port.out.MemberPersistent;
import com.lx.board.domain.member.domain.Member;
import com.lx.board.domain.member.repository.entity.MemberEntity;
import com.lx.board.domain.member.repository.jpa.MemberJpaRepository;
import com.lx.board.global.exception.BusinessException;
import com.lx.board.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MemberRepository implements MemberPersistent {

    private final MemberJpaRepository memberRepository;

    @Override
    public String save(Member member) {
        MemberEntity memberEntity = new MemberEntity(member.getUsername(), member.getPassword(), member.getNickname());
        memberRepository.save(memberEntity);
        return memberEntity.getId().toString();
    }

    @Override
    public void update(Member member) {
        MemberEntity memberEntity = memberRepository.findById(UUID.fromString(member.getId())).orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND));
        memberEntity.update(member.getUsername(), member.getPassword(), member.getNickname());
    }

    @Override
    public Member findById(String id) {
        MemberEntity memberEntity = memberRepository.findById(UUID.fromString(id)).orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND));
        return Member.createWithId(memberEntity.getId().toString(), memberEntity.getUsername(), memberEntity.getPassword(), memberEntity.getNickname());
    }

    @Override
    public Member findByUsername(String username) {
        MemberEntity memberEntity = memberRepository.findByUsername(username).orElse(null);
        if (memberEntity == null) return null;
        return Member.createWithId(memberEntity.getId().toString(), memberEntity.getUsername(), memberEntity.getPassword(), memberEntity.getNickname());
    }


}
