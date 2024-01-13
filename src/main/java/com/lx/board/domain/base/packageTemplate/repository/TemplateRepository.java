package com.lx.board.domain.base.packageTemplate.repository;

import com.lx.board.domain.base.packageTemplate.application.port.out.TemplatePersistent;
import com.lx.board.domain.base.packageTemplate.repository.jpa.TemplateJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TemplateRepository implements TemplatePersistent {

    private final TemplateJpaRepository templateJpaRepository;
}
