package com.lx.board.domain.base.packageTemplate.repository.jpa;

import com.lx.board.domain.base.packageTemplate.repository.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateJpaRepository extends JpaRepository<TemplateEntity, Long> {
}
