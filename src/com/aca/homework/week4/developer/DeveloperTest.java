package com.aca.homework.week4.developer;

public class DeveloperTest {

    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setName("Gerard");
        developer.print();

        Developer juniorDev = new JuniorDeveloper();
        juniorDev.setName("Maricar");
        juniorDev.print();

        Developer seniorDev = new SeniorDeveloper();
        seniorDev.setName("Emily");
        seniorDev.print();

    }
}
