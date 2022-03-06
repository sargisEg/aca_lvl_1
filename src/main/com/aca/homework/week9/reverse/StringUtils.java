package com.aca.homework.week9.reverse;

public class StringUtils {

    public static String reverse(String string) {

        if (string == null)
            throw new IllegalArgumentException("Given String is null");
        if(string.equals(""))
            return "";

        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = string.length() - 1; i >= 0; i--) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }
}
