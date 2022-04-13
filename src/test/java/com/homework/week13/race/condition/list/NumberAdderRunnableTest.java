package com.homework.week13.race.condition.list;

import com.aca.homework.week13.race.condition.list.List;
import com.aca.homework.week13.race.condition.list.NumberAdderRunnable;
import com.aca.homework.week13.race.condition.list.UnsafeList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class NumberAdderRunnableTest {

    @Test
    public void testRun() {
        List<Integer> testList = new UnsafeList<>();
        Runnable testSubject = new NumberAdderRunnable(testList, 5);
        testSubject.run();
        Assertions.assertEquals(1, testList.size());
    }
}