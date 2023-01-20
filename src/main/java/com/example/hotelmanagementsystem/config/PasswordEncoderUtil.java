package com.example.hotelmanagementsystem.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private PasswordEncoderUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static BCryptPasswordEncoder getInstance() {
        return PASSWORD_ENCODER;
    }
}
