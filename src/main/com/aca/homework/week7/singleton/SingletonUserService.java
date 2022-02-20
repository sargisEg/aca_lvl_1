package com.aca.homework.week7.singleton;

public class SingletonUserService {

    private static SingletonUserService instance = null;

    private SingletonUserService() {
    }

    public static SingletonUserService getInstance() {
        if (instance == null) {
            instance = new SingletonUserService();
        }
        return instance;
    }
}
