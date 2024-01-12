package com.lx.board.domain.board.port.out;

import com.lx.board.domain.board.domain.Board;

public interface BoardPersistent {

    Long save(Board board);
}
