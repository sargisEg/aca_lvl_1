package com.aca.homework.week12.thread;

public class ThreadTermination {

    public static void main(String[] args) {
        System.out.println("Started");

        Thread thread = new Thread(new RunnableImpl());
        thread.start();
        Thread thread1 = new Thread(new RunnableImpl());
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }

    private static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis());
        }
    }
}
