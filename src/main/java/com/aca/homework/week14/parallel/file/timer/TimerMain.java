package com.aca.homework.week14.parallel.file.timer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TimerMain {

    private final static String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week14/parallel/file/timer/";

    public void startTimer(TimerRunnable runnable) {
        new Thread(runnable).start();
    }

    public int getSecondFromFile(String fileName) {
        ObjectInputStream objectInputStream = null;
        try {
             objectInputStream = new ObjectInputStream(
                    new FileInputStream(PATH + fileName)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sec = 0;

        try {
            sec = objectInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sec;
    }
}
