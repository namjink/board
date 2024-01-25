package com.lx.board.domain.base.domain;

import com.lx.board.domain.base.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;



@Getter
public abstract class BaseTimeDomain {

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public <T extends BaseTimeDomain> T stampTime(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        return (T) this;
    }
}
