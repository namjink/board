package com.lx.board.domain.member.repository;

import com.lx.board.domain.member.application.port.out.MemberPersistent;
import com.lx.board.domain.member.domain.Member;
import com.lx.board.domain.member.repository.entity.MemberEntity;
import com.lx.board.domain.member.repository.jpa.MemberJpaRepository;
import com.lx.board.global.exception.BusinessException;
import com.lx.board.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberPersistent {

    private final MemberJpaRepository memberRepository;

    @Override
    public Member save(Member member) {
        MemberEntity memberEntity = new MemberEntity(member.getUsername(), member.getPassword(), member.getNickname());
        memberRepository.save(memberEntity);
        return toDomain(memberEntity);
    }

    @Override
    public Member update(Member member) {
        MemberEntity memberEntity = memberRepository.findById(member.getId()).orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND));
        memberEntity.update(member.getUsername(), member.getPassword(), member.getNickname());
        return toDomain(memberEntity);
    }

    @Override
    public Member findById(UUID id) {
        MemberEntity memberEntity = memberRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND));
        return toDomain(memberEntity);
    }

    @Override
    public Member findByUsername(String username) {
        MemberEntity memberEntity = memberRepository.findByUsername(username).orElse(null);
        if (memberEntity == null) return null;
        return toDomain(memberEntity);
    }

    private Member toDomain(MemberEntity memberEntity) {
        return Member.createWithId(memberEntity.getId(), memberEntity.getUsername(), memberEntity.getPassword(), memberEntity.getNickname());
    }

}
