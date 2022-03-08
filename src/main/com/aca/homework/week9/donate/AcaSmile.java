package com.aca.homework.week9.donate;


import java.util.ArrayList;
import java.util.List;

public class AcaSmile {

    private double donations;
    private List<String> donatedGoods = new ArrayList<>();

    public <T extends Donatable> void buyWithDonation(T donatableGood) {
        System.out.println(donatableGood + " is bought");
        System.out.println(donatableGood.donationAmount() + " is donated");
        donations += donatableGood.donationAmount();
        donatedGoods.add(donatableGood.toString());
    }

    public double getTotalDonatedAmount() {
        return donations;
    }

    public List<String> getDonatedGoods() {
        return donatedGoods;
    }
}
