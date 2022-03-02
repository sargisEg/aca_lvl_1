package com.aca.homework.week8.checked.unchecked.exceptions;

public class Main {
    public static void main(String[] args) {
        try {
            method1();
        } catch (RuntimeException e) {
            System.out.println("catch");
        }

        System.out.println("finished");
    }

    public static void method1() {
            method2();
    }

    public static void method2() {
            method3();
    }

    public static void method3() {
        try {
            method4();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void method4() throws Exception {
        method5();
    }

    public static void method5() throws Exception {
        throw new Exception();
    }
}
