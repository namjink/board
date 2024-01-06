package com.lx.board.domain.member.repository;

import com.lx.board.domain.member.application.port.out.MemberPersistent;
import com.lx.board.domain.member.domain.Member;
import com.lx.board.domain.member.repository.entity.MemberEntity;
import com.lx.board.global.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class MemberRepository implements MemberPersistent {

    private final HashMap<String, MemberEntity> memberMap;

    public MemberRepository() {
        this.memberMap = new HashMap<>();
    }

    @Override
    public String save(Member member) {
        String id = UUID.randomUUID().toString();
        MemberEntity memberEntity = new MemberEntity(member.getUsername(), member.getPassword(), member.getNickname());
        memberMap.put(id, memberEntity);
        return id;
    }

    @Override
    public void update(Member member) {
        String id = member.getId();
        MemberEntity memberEntity = new MemberEntity(member.getUsername(), member.getPassword(), member.getNickname());
        memberMap.replace(id, memberEntity);
    }

    @Override
    public Member findById(String id) {
        MemberEntity memberEntity = memberMap.get(id);
        return Member.createWithId(id, memberEntity.username(), memberEntity.password(), memberEntity.nickname());
    }

    @Override
    public Member findByUsername(String username) {
        Optional<Map.Entry<String, MemberEntity>> memberEntry = memberMap.entrySet().stream().filter(stringMemberEntityEntry -> stringMemberEntityEntry.getValue().username().equals(username)).findFirst();
        MemberEntity memberEntity = memberEntry.orElseThrow(() -> new BusinessException("해당 아이디로 가입된 회원은 존재하지 않습니다.")).getValue();
        return Member.createWithId(memberEntry.get().getKey(), memberEntity.username(), memberEntity.password(), memberEntity.nickname());
    }


}
