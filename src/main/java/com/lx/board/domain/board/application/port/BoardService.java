package com.lx.board.domain.board.application.port;

import com.lx.board.domain.board.application.port.in.BoardReadCase;
import com.lx.board.domain.board.application.port.in.BoardWriteCase;
import com.lx.board.domain.board.application.port.out.BoardPersistent;
import com.lx.board.domain.board.domain.Board;
import com.lx.board.domain.board.dto.request.PostBoardRequest;
import com.lx.board.domain.board.dto.response.CommonBoardResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService implements BoardReadCase, BoardWriteCase {

    private final BoardPersistent boardPersistent;

    @Override
    public CommonBoardResponse getBoardById(Long boardId) {
        Board board =  boardPersistent.findById(boardId);
        return toResponse(board);
    }

    @Override
    public List<CommonBoardResponse> getAllBoard() {
        return boardPersistent.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public CommonBoardResponse postBoard(PostBoardRequest postBoardRequest) {
        Board board = Board.create(postBoardRequest.title(), postBoardRequest.description());
        board = boardPersistent.save(board);
        return toResponse(board);
    }

    private CommonBoardResponse toResponse(Board board) {
        return new CommonBoardResponse(board.getId(), board.getTitle(), board.getDescription());
    }
}
