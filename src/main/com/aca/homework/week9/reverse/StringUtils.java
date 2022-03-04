package com.aca.homework.week9.reverse;

public class StringUtils {

    public static String reverse(String string) {

        if (string == null)
            throw new IllegalArgumentException();
        if(string.equals(""))
            return "";

        StringBuilder stringBuilder = new StringBuilder("");

        if (string.length() == 1)
            return stringBuilder.append(string.charAt(0)).toString();
        stringBuilder.append(reverse(string.substring(1)));
        stringBuilder.append(string.charAt(0));
        return stringBuilder.toString();
    }
}
