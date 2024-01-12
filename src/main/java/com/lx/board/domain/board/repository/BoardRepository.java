package com.lx.board.domain.board.repository;

import com.lx.board.domain.board.domain.Board;
import com.lx.board.domain.board.port.out.BoardPersistent;
import com.lx.board.domain.board.repository.entity.BoardEntity;
import com.lx.board.domain.board.repository.jpa.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardRepository implements BoardPersistent {

    private final BoardJpaRepository boardRepository;
    @Override
    public Long save(Board board) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(board.getTitle())
                .description(board.getDescription())
                .build();
        boardRepository.save(boardEntity);
        return boardEntity.getId();
    }
}
