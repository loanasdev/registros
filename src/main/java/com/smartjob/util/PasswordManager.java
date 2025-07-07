package com.smartjob.util;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class PasswordManager {
    public static String encryptPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        try {
            return hashedPassword.equals(encryptPassword(password));
        } catch (Exception e) {
            return false;
        }
    }
}