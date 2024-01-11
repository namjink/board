package com.lx.board.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //401
    UNAUTHENTICATED_MEMBER(UNAUTHORIZED, "사용자 정보가 존재하지 않습니다."),
    UNAUTHORIZED_MEMBER(UNAUTHORIZED, "권한이 없는 사용자입니다."),

    //404
    RESOURCE_NOT_FOUND(NOT_FOUND, "요청된 정보를 찾을 수 없습니다."),

    //409
    DUPLICATE_RESOURCE(CONFLICT, "중복된 데이터가 존재합니다."),

    //500
    NOT_YET_IMPLEMENTED(NOT_IMPLEMENTED, "아직 구현되지 않은 기능입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
