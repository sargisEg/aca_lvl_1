package com.aca.homework.week8.payment_service;

import java.util.Random;

@Service
public class PaymentService {

    public PayResult pay(int money) {
        long startMillis = System.currentTimeMillis();
        waitSomeSec();
        return PayResult.ofResult(money,System.currentTimeMillis() - startMillis);
    }

    private void waitSomeSec(){
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= new Random().nextInt(800)+200);
    }
}
