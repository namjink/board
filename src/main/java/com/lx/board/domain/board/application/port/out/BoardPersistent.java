package com.lx.board.domain.board.application.port.out;

import com.lx.board.domain.board.domain.Board;

import java.util.List;

public interface BoardPersistent {

    Board save(Board board);

    Board findById(Long boardId);

    List<Board> findAll();
}
