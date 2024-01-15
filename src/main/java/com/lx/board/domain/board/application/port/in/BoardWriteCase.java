package com.lx.board.domain.board.application.port.in;

import com.lx.board.domain.board.dto.request.PostBoardRequest;
import com.lx.board.domain.board.dto.response.CommonBoardResponse;

public interface BoardWriteCase {

    CommonBoardResponse postBoard(PostBoardRequest postBoardRequest);

}
