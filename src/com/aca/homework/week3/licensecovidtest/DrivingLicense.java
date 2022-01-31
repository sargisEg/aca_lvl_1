package com.aca.homework.week3.licensecovidtest;

public class DrivingLicense {
    private User user;
    private char[] categories;

    public DrivingLicense(User user, char[] categories){
        this.user = user;
        setCategories(categories);
    }

    public void setCategories(char[] categories) {
        this.categories = categories;
    }

    public void showLicense(){
        System.out.println("Showing license");
        System.out.print("Type of license: ");
        for (int i = 0; i < this.categories.length; i++) {
            System.out.print(this.categories[i] + " ");
        }
        System.out.println("");
    }
}

/*
Create a DrivingLicense class that has fields user and an array of granted license categories
(may contain 'A', 'B, 'C', 'D', 'E')
*/

