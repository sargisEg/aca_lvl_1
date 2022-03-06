package com.aca.homework.week9.calculator;

import java.util.Scanner;

public class SimpleCalculator {

    ExpressionSupplier expressionSupplier;

    public SimpleCalculator(ExpressionSupplier expressionSupplier) {
        this.expressionSupplier = expressionSupplier;
    }

    public String askAndCalculate() {

        String expression = expressionSupplier.getExpression();

        if (expression.length() != 3) {
            System.out.println("error");
            return "error";
        }
        int first;
        int second;
        try {
            first = Integer.parseInt(expression.substring(0, 1));
            second = Integer.parseInt(expression.substring(2));
        } catch (NumberFormatException e) {
            System.out.println("error");
            return "error";
        }

        return calculate(expression.charAt(1), first, second);
    }

    private String calculate(char operation, int first, int second) {

        if (operation == Operation.ADDITION.getOperationSymbol()) {
            System.out.println(first + second);
            return String.valueOf(first + second);
        } else if (operation == Operation.SUBTRACTION.getOperationSymbol()) {
            System.out.println(first - second);
            return String.valueOf(first - second);
        } else if (operation == Operation.DIVISION.getOperationSymbol()) {
            System.out.println((double) first / (double) second);
            return String.valueOf((double) first / (double) second);
        } else if (operation == Operation.MULTIPLICATION.getOperationSymbol()) {
            System.out.println(first * second);
            return String.valueOf(first * second);
        } else {
            System.out.println("error");
            return "error";
        }
    }
}