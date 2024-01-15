package com.lx.board.domain.board.repository;

import com.lx.board.domain.board.domain.Board;
import com.lx.board.domain.board.application.port.out.BoardPersistent;
import com.lx.board.domain.board.repository.entity.BoardEntity;
import com.lx.board.domain.board.repository.jpa.BoardJpaRepository;
import com.lx.board.global.exception.BusinessException;
import com.lx.board.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardRepository implements BoardPersistent {

    private final BoardJpaRepository boardRepository;
    @Override
    public Board save(Board board) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(board.getTitle())
                .description(board.getDescription())
                .build();
        boardRepository.save(boardEntity);
        return toDomain(boardEntity);
    }

    @Override
    public Board findById(Long boardId) {
        BoardEntity board = boardRepository.findById(boardId).orElseThrow(() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, "해당하는 Id의 게시판이 존재하지 않습니다."));
        return toDomain(board);
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Board toDomain(BoardEntity boardEntity) {
        return Board.createWithId(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getDescription());
    }
}
