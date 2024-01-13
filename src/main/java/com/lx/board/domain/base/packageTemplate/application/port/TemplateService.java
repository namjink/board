package com.lx.board.domain.base.packageTemplate.application.port;

import com.lx.board.domain.base.packageTemplate.application.port.in.TemplateReadCase;
import com.lx.board.domain.base.packageTemplate.application.port.in.TemplateWriteCase;
import com.lx.board.domain.base.packageTemplate.application.port.out.TemplatePersistent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TemplateService implements TemplateReadCase, TemplateWriteCase {

    private final TemplatePersistent templatePersistent;
}
