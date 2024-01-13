package com.lx.board.init;

import com.lx.board.domain.board.domain.Board;
import com.lx.board.domain.board.application.port.out.BoardPersistent;
import com.lx.board.domain.member.application.port.out.MemberPersistent;
import com.lx.board.domain.member.domain.Member;
import com.lx.board.global.inteceptor.APIInterceptor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
public class InitRunner implements ApplicationRunner {

    private final MemberPersistent memberPersistent;
    private final BoardPersistent boardPersistent;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Member member = null;
        if (memberPersistent.findByUsername("test") == null) {

            member = Member.create("test", "test", "test");
            member = memberPersistent.save(member);

            APIInterceptor.loginMember.set(member.getId());

            Board board = Board.create("test", "test");

            boardPersistent.save(board);
        }
    }
}
