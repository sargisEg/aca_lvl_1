package com.aca.homework.week14.parallel.file.timer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TimerRunnable implements Runnable {

    private final static String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week14/parallel/file/timer/";
    private final String fileName;
    private int seconds = 0;
    private volatile boolean isRunning = true;

    public TimerRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ObjectOutputStream objectOutputStream = null;

            try {
                objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream(PATH + fileName + ".txt")
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                objectOutputStream.writeInt((int)(System.currentTimeMillis() - start) / 1000);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }
}
