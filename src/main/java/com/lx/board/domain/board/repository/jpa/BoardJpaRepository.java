package com.lx.board.domain.board.repository.jpa;

import com.lx.board.domain.board.repository.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, Long> {
}
