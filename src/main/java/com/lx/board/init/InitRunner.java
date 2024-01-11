package com.lx.board.init;

import com.lx.board.domain.member.application.port.out.MemberPersistent;
import com.lx.board.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

    private final MemberPersistent memberPersistent;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (memberPersistent.findByUsername("test") == null) {
            memberPersistent.save(Member.create("test", "test", "test"));
        }
    }
}
