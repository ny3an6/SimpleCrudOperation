package com.ndmitrenko.dinosystemsrestapi.util;

public class ToUpperCaseString {
    public static String toUpperCase(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.setCharAt(0, Character.toUpperCase(text.charAt(0)));

        return builder.toString();
    }
}
