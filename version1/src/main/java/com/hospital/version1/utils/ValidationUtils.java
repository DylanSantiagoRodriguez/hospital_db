package com.hospital.version1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phonePattern = "^\\d{10}$"; 
        return phoneNumber.matches(phonePattern);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
