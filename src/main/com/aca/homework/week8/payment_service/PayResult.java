package com.aca.homework.week8.payment_service;

public class PayResult {
    private int payAmount;
    private long processingTime;

    public PayResult(int payAmount, long processingTime) {
        this.payAmount = payAmount;
        this.processingTime = processingTime;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public long getProcessingTime() {
        return processingTime;
    }
}
