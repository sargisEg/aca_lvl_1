package com.homework.week9.observable.list;

import com.aca.homework.week9.observable.list.ArrayObservableList;
import com.aca.homework.week9.observable.list.MockListChangeListener;
import com.aca.homework.week9.observable.list.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayObservableListTest {

    @Test
    public void testAddWhenThereIsNoAddedListeners() {
        ObservableList<String> testSubject = new ArrayObservableList<>();
        Assertions.assertEquals(0, testSubject.size());
        testSubject.add("test");
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals("test", testSubject.get(0));
    }

    @Test
    public void testAddWhenThereIsOneAddedListener() {
        ObservableList<Integer> testSubject = new ArrayObservableList<>();
        MockListChangeListener<Integer> mockListener = new MockListChangeListener<>();
        testSubject.addListener(mockListener);
        testSubject.add(Integer.valueOf(98));
        Assertions.assertEquals(1, mockListener.getMethodCount());
    }

    @Test
    public void testAddWhenThereAreTwoAddedListener() {
        ObservableList<Integer> testSubject = new ArrayObservableList<>();
        MockListChangeListener<Integer> mockListener1 = new MockListChangeListener<>();
        MockListChangeListener<Integer> mockListener2 = new MockListChangeListener<>();
        testSubject.addListener(mockListener1);
        testSubject.addListener(mockListener2);
        testSubject.add(Integer.valueOf(98));
        testSubject.add(Integer.valueOf(99));
        Assertions.assertEquals(2, mockListener1.getMethodCount());
        Assertions.assertEquals(2, mockListener2.getMethodCount());

    }
}