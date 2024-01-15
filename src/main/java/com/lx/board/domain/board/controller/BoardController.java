package com.lx.board.domain.board.controller;

import com.lx.board.domain.board.application.port.in.BoardReadCase;
import com.lx.board.domain.board.application.port.in.BoardWriteCase;
import com.lx.board.domain.board.dto.request.PostBoardRequest;
import com.lx.board.domain.board.dto.response.CommonBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardWriteCase boardWriteCase;
    private final BoardReadCase boardReadCase;

    @PostMapping
    public CommonBoardResponse postBoard(@RequestBody PostBoardRequest postBoardRequest) {
        return boardWriteCase.postBoard(postBoardRequest);
    }

    @GetMapping("/{id}")
    public CommonBoardResponse getBoardById(@PathVariable(name = "id") Long boardId) {
        return boardReadCase.getBoardById(boardId);
    }

    @GetMapping
    public List<CommonBoardResponse> getAllBoard() {
        return boardReadCase.getAllBoard();
    }
}
