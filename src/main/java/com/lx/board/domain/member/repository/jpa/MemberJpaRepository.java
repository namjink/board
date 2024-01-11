package com.lx.board.domain.member.repository.jpa;

import com.lx.board.domain.member.repository.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, UUID> {

    Optional<MemberEntity> findByUsername(String username);
    Optional<MemberEntity> findByNickname(String username);
}
