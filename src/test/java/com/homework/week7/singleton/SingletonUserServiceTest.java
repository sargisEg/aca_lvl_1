package com.homework.week7.singleton;

import com.aca.homework.week7.singleton.SingletonUserService;

class SingletonUserServiceTest {

    public static void main(String[] args) {
        SingletonUserService object0 = SingletonUserService.getInstance();
        SingletonUserService object1 = SingletonUserService.getInstance();
        SingletonUserService object2 = SingletonUserService.getInstance();
        SingletonUserService object3 = SingletonUserService.getInstance();

        System.out.println(object0 == object1);
        System.out.println(object1 == object2);
        System.out.println(object2 == object3);

    }
}