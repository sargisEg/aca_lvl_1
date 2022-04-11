package com.aca.homework.week9.calculator;

import java.util.Scanner;

public class UserInputExpressionSupplier implements ExpressionSupplier {

    @Override
    public String getExpression() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
