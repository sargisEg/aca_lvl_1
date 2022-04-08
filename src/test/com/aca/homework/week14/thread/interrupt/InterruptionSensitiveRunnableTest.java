package com.aca.homework.week14.thread.interrupt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class InterruptionSensitiveRunnableTest {

    private Runnable testSubject;
    private List<String> sharedList;

    @BeforeEach
    public void setUp() {
        sharedList = new LinkedList<>();
        testSubject = new InterruptionSensitiveRunnable(sharedList);
    }

    @Test
    public void testImmediateInterrupt() {
        Thread thread1 = new Thread(testSubject);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            System.out.println();
            thread1.interrupt();
            System.out.println();
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(0, sharedList.size());
    }
    // start the thread, interrupt it as soon as possible, wait until all threads stop the work, and assert that the shared list size is 0
    @Test
    public void testInterruptIn1Sec() {
        Thread thread1 = new Thread(testSubject);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            thread1.interrupt();
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(0, sharedList.size());
    }
    // start the thread, interrupt it in 1 sec, wait until all threads stop the work, and assert that the shared list size is 0
    @Test
    public void testInterruptIn3Sec() {
        Thread thread1 = new Thread(testSubject);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return;
            }
            thread1.interrupt();
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(1, sharedList.size());
    }
    // start the thread, interrupt it in 3 sec, wait until all threads stop the work, and assert that the shared list size is 1
    @Test
    public void testInterruptIn5Sec() {
        Thread thread1 = new Thread(testSubject);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
            thread1.interrupt();
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(2, sharedList.size());
    }
    // start the thread, interrupt it in 5 sec, wait until all threads stop the work, and assert that the shared list size is 2



}