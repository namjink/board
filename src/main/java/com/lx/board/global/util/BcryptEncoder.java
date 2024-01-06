package com.lx.board.global.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptEncoder {

    private final static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(String target) {
        return bCryptPasswordEncoder.encode(target);
    }

    public static boolean match(String input, String data) {
        return bCryptPasswordEncoder.matches(input, data);
    }
}
