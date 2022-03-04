package com.aca.homework.week9.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

    @Test
    public void testWhenInputStringLengthIs1() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "a";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs2() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "aa";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs4() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "aaaa";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs3ButFirstSymbolIsNotDigit() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "a+4";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs3ButSecondSymbolIsNotOperation() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "1a1";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs3ButThirdSymbolIsNotOperation() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "7+a";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsSum() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "7+7";
            }
        });
        Assertions.assertEquals("14", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsDivision() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "2/5";
            }
        });
        Assertions.assertEquals("0.4", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsSubtraction() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "7-7";
            }
        });
        Assertions.assertEquals("0", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsMultiplication() {
        SimpleCalculator testSubject = new SimpleCalculator(new ExpressionSupplier() {
            @Override
            public String getExpression() {
                return "2*5";
            }
        });
        Assertions.assertEquals("10", testSubject.askAndCalculate());
    }


}