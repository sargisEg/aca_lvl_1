package com.aca.homework.week7.car.tax;

public enum CarType {
    ELECTRIC() {
        @Override
        public int annualTex(int age) {
            return 5;
        }
    },
    HYBRID() {
        @Override
        public int annualTex(int age) {
            return 5 * age;
        }
    };

    public abstract int annualTex(int age);
}