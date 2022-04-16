package com.app.rapidnumberconverter.utils;

public class TranslationUtils {

    public static String translateBinary(String plainText) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] binary = plainText.split(" ", -1);
        for (String character : binary) {
            int code = Integer.parseInt(character, 2);
            String a = String.valueOf((char) code);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }
}
