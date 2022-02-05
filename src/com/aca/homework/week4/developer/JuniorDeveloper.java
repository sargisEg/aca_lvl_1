package com.aca.homework.week4.developer;

public class JuniorDeveloper extends Developer {

    @Override
    public int getLearningBudget() {
        return super.getLearningBudget()*2;
    }

    @Override
    public int getSalary() {
        return 300_000;
    }


}

/*
Create JuniorDeveloper subclass superclass of which is the Developer.
The learning budget should be x2 of one an ordinary developer has and the salary should be 300_000.*/