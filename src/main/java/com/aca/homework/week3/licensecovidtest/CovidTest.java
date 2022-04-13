package com.aca.homework.week3.licensecovidtest;

public class CovidTest {
    private User user;
    private String result; // can be "undefined", "positive", "negative"

    public static void main(String[] args) {

    }

    public CovidTest(User user){
        this.user = user;
        this.result = "undefined"; // by default
    }

    public void test(){
        System.out.println("Testing for COVID.....");
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() < time+3000);


        this.setResult((int)(Math.random()*2) == 1 ? "positive" : "negative");
        System.out.println(getResult());
    }

    public void setResult(String result) {
        if (result.equals("positive") || result.equals("negative")){
            this.result = result;
        }else
            throw new IllegalArgumentException("Result can be positive or negative");
    }

    public String getResult() {
        return "Result is " + result;
    }
}

/*
Create a CovidTest class that has fields user and result.
The result can be one of the following values: "undefined", "positive", "negative".

By default, the covid test result should be "undefined".

Make all User's and CovidTest's fields private.

Create a test() method in CovidTest class which in 3 seconds randomly set any test result.
*/
