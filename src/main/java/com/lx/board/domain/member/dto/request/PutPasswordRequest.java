package com.lx.board.domain.member.dto.request;

public record PutPasswordRequest(String id, String oldPassword, String newPassword) {
}
