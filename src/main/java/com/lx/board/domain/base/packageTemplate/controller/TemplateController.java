package com.lx.board.domain.base.packageTemplate.controller;

import com.lx.board.domain.base.packageTemplate.application.port.in.TemplateReadCase;
import com.lx.board.domain.base.packageTemplate.application.port.in.TemplateWriteCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateWriteCase templateWriteCase;
    private final TemplateReadCase templateReadCase;
}
