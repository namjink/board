package com.lx.board.domain.board.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class Board {

    private Long id;
    private String title;
    private String description;

    public static Board create(String title, String description) {
        return Board.builder()
                .title(title)
                .description(description)
                .build();
    }

    public static Board createWithId(Long id, String title, String description) {
        return Board.builder()
                .id(id)
                .title(title)
                .description(description)
                .build();
    }

}
