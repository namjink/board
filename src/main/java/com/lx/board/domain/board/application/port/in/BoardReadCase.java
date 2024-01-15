package com.lx.board.domain.board.application.port.in;

import com.lx.board.domain.board.dto.response.CommonBoardResponse;

import java.util.List;

public interface BoardReadCase {

    CommonBoardResponse getBoardById(Long boardId);
    List<CommonBoardResponse> getAllBoard();
}
