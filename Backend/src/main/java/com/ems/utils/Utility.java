package com.ems.utils;

import java.security.SecureRandom;

public class Utility {
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 12;

    public static String generateRoomCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            result.append(CHARACTERS.charAt(index));
        }

        return result.toString();
    }
}
