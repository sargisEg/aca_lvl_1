package com.aca.homework.week9.calculator;

public enum Operation {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public char getOperationSymbol() {
        return operationSymbol;
    }
}
