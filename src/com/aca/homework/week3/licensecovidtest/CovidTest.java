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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setResult((int)(Math.random()*2) == 1 ? "positive" : "negative");
        System.out.println(getResult());
    }

    public void setResult(String result) {
        if (result == "positive" || result == "negative"){
            this.result = result;
        }else
            throw new RuntimeException("Result can be positive or negative");
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
