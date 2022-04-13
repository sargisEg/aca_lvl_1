package com.aca.homework.week3.licensecovidtest;

public class Main {

    public static void main(String[] args) {
        User user = new User("Vova","vova_gasparyan");

        char[] licanse = new char[]{'B','C'};
        DrivingLicense drivingLicense = new DrivingLicense(user,licanse);

        CovidTest newCovidTest = new CovidTest(user);

        drivingLicense.showLicense();
        newCovidTest.test();

    }
}

/*
There is a person having "vova_gasparyan" username and "Vova" name who gave a test and waiting to see his covid test result.
Before giving a test the policeman stopped Vova who had to show his driving license of BC type.

note: Only User, CovidTest, DrivingLicense, and Main classes should be created.
*/
