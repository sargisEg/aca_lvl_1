package com.aca.homework.week4.developer;

public class SeniorDeveloper extends Developer {

    @Override
    public int getLearningBudget() {
        return super.getLearningBudget()*8;
    }

    @Override
    public int getSalary() {
        return 3_000_000;
    }
}

/*Create SeniorDeveloper subclass superclass of which is the Developer.
The learning budget should be x8 of one an ordinary developer has and the salary should be 3_000_000.*/