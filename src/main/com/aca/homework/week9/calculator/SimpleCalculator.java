package com.aca.homework.week9.calculator;

import java.util.Scanner;

public class SimpleCalculator {

    ExpressionSupplier expressionSupplier;

    public SimpleCalculator(ExpressionSupplier expressionSupplier) {
        this.expressionSupplier = expressionSupplier;
    }

    public static void main(String[] args) {
        String txt = "a7b";
        char n = txt.charAt(0);
        int a = n - '0';
        System.out.println(a);
    }

    public String askAndCalculate() {

        String expression = expressionSupplier.getExpression();

        if (expression.length() != 3) {
            System.out.println("error");
            return "error";
        }

        int first = expression.charAt(0) - '0';
        int second = expression.charAt(2) - '0';

        if(first > 9 || second > 9) {
            System.out.println("error");
            return "error";
        }

        Operation operation = Operation.of(expression.charAt(1));
        if(operation == null) {
            System.out.println("error");
            return "error";
        }
        return String.valueOf(operation.calculate(first,second));
    }
}