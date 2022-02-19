package com.aca.homework.week4.jsonprocessor;

import java.util.Scanner;

public class Json {


    public static void main(String[] args) {
        String json = "{\"name\": \"Kate\", \"surname\": \"Smith\", \"age\": \"10\"}";
        StringProcessor stringProcessor = new StringProcessor(json);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("please input a field name:");
            String key = scanner.next();
            if (key.equals("end"))
                break;
            System.out.println(stringProcessor.getValue(key));
        }

    }


}
