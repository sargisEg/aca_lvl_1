package com.aca.homework.week14.parallel.file.timer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimerMainTest {

    private TimerMain testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new TimerMain();
    }

    @Test
    public void test5And3() {
        TimerRunnable timer1 = new TimerRunnable("timer1");
        testSubject.startTimer(timer1);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TimerRunnable timer2 = new TimerRunnable("timer2");
        testSubject.startTimer(timer2);
        try {
            Thread.sleep(3200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer1.stop();
        timer2.stop();

        Assertions.assertEquals(5, testSubject.getSecondFromFile("timer1.txt"));
        Assertions.assertEquals(3, testSubject.getSecondFromFile("timer2.txt"));
    }

    @Test
    public void test5And5() {
        TimerRunnable timer1 = new TimerRunnable("timer1");
        testSubject.startTimer(timer1);

        TimerRunnable timer2 = new TimerRunnable("timer2");
        testSubject.startTimer(timer2);
        try {
            Thread.sleep(5200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer1.stop();
        timer2.stop();

        Assertions.assertEquals(5, testSubject.getSecondFromFile("timer1.txt"));
        Assertions.assertEquals(5, testSubject.getSecondFromFile("timer2.txt"));
    }
}