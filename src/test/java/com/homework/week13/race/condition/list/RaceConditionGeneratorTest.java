package com.homework.week13.race.condition.list;

import com.aca.homework.week13.race.condition.list.RaceConditionGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class RaceConditionGeneratorTest {

    @Test
    public void testForUnsafeList() {
        RaceConditionGenerator conditionGenerator = new RaceConditionGenerator((Supplier<Boolean>) ()-> {
            return false;
        });
        Assertions.assertNotEquals(10_000, conditionGenerator.start());
    }

    @Test
    public void testForSafeList() {
        RaceConditionGenerator conditionGenerator = new RaceConditionGenerator((Supplier<Boolean>) ()-> {
            return true;
        });
        Assertions.assertEquals(10_000, conditionGenerator.start());
    }
}