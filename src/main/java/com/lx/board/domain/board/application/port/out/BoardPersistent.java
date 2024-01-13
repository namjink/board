package com.lx.board.domain.board.application.port.out;

import com.lx.board.domain.board.domain.Board;

public interface BoardPersistent {

    Board save(Board board);
}
