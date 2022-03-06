package com.aca.homework.week9.calculator;

public class SimpleCalculator {

    private ExpressionSupplier expressionSupplier;

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

        if(isLengthNot3(expression))
            return "error";

        int first = expression.charAt(0) - '0';
        int second = expression.charAt(2) - '0';
        Operation operation = Operation.of(expression.charAt(1));

        if(isNumbersInvalid(first,second))
            return "error";
        if (isOperationInvalid(operation))
            return "error";

        return String.valueOf(operation.calculate(first,second));
    }

    private boolean isLengthNot3(String expression) {
        if (expression.length() != 3) {
            System.out.println("error");
            return true;
        }
        return false;
    }

    private boolean isNumbersInvalid(int first, int second) {
        if(first > 9 || second > 9) {
            System.out.println("error");
            return true;
        }
        return false;
    }

    private boolean isOperationInvalid(Operation operation) {
        if(operation == null) {
            System.out.println("error");
            return true;
        }
        return false;
    }
}