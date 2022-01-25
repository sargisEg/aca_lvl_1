package com.aca.homework.week3.covidtest;

public class CovidTest {
    boolean positive;
    User user = new User();

    public static void main(String[] args) {
        CovidTest test1 = new CovidTest();
        CovidTest test2 = new CovidTest();
        CovidTest test3 = new CovidTest();

        test1.positive = true;
        test1.user.code = "mark789";
        test1.user.name = "Mark";

        test2.positive = true;
        test2.user.code = "jane45";
        test2.user.name = "Jane";

        test3.positive = false;
        test3.user.code = "kate876&";
        test3.user.name = "Kate";

        printCovidTest(test1);
        test2.print();
        test3.print();

    }


    public static void printCovidTest(CovidTest covidTest){
        System.out.println("Name: " + covidTest.user.name +
                            "\nCode: " + covidTest.user.code +
                            "\nResult: " + (covidTest.positive ? "Positive" : "Negative"));
    }

    public void print(){
        user.print();
        System.out.println("Result: " + (positive ? "Positive" : "Negative"));
    }

}