package com.example.bg.util;

import java.util.UUID;

public class ReferenceCodeUtil {

    public static String generate() {
        return "BG-" + UUID.randomUUID()
                .toString()
                .substring(0, 6)
                .toUpperCase();
    }
}
