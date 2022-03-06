package com.aca.homework.week9.calculator;

public enum Operation {
    ADDITION('+') {
        @Override
        public double calculate(int first, int second) {
            return first + second;
        }
    },
    SUBTRACTION('-') {
        @Override
        public double calculate(int first, int second) {
            return first - second;
        }
    },
    MULTIPLICATION('*') {
        @Override
        public double calculate(int first, int second) {
            return first * second;
        }
    },
    DIVISION('/') {
        @Override
        public double calculate(int first, int second) {
            return (double) first / (double) second;
        }
    };

    private char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public abstract double calculate(int first, int second);

    public static Operation of(char operationType) {
        for (Operation operation : Operation.values()) {
            if(operation.operationSymbol == operationType)
                return operation;
        }
        return null;
    }
}
