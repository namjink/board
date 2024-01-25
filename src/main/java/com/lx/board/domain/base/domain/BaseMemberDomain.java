package com.lx.board.domain.base.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public abstract class BaseMemberDomain extends BaseTimeDomain {

    private UUID createdBy;

    private UUID modifiedBy;

    public <T extends BaseMemberDomain> T stampMember(UUID createdBy, UUID modifiedBy) {
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        return (T) this;
    }
}
