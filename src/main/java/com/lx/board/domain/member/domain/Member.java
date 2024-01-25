package com.lx.board.domain.member.domain;

import com.lx.board.domain.base.domain.BaseTimeDomain;
import com.lx.board.global.util.BcryptEncoder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class Member extends BaseTimeDomain {

    private UUID id;

    private String username;

    private String password;

    private String nickname;

    public static Member create(String username, String password, String nickname) {
        return Member.builder()
                .username(username)
                .password(encode(password))
                .nickname(nickname)
                .build();
    }

    public static Member createWithId(UUID id, String username, String password, String nickname) {
        return Member.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
    }

    public void generateId(UUID id) {
        this.id = id;
    }

    public boolean login(String password) {
        return BcryptEncoder.match(password, this.password);
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (!login(oldPassword)) return false;
        this.password = encode(newPassword);
        return true;

    }

    private static String encode(String target) {
        return BcryptEncoder.encode(target);
    }
}
