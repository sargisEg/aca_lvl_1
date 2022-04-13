package com.homework.week13.entity.info;

import com.aca.homework.week13.entity.info.EntityProcessor;
import com.aca.homework.week13.entity.info.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityProcessorTest {


    @Test
    public void testPrintInfoWhenObjectIsProduct() {
        final boolean[] flag = {false};
        EntityProcessor processor = new EntityProcessor(s -> {
            if (s.equals("table name is: PRODUCT, ID is: 3586483, NAME is: something")) {
                flag[0] = true;
            }
        });
        processor.printInfo(new Product(3586483L, "something"));
        Assertions.assertTrue(flag[0]);
    }

    @Test
    public void testPrintInfoWhenObjectIsString() {

        final boolean[] flag = {false};
        EntityProcessor processor = new EntityProcessor(s -> {
            if (s.equals("")) {
                flag[0] = true;
            }
        });
        processor.printInfo("string");
        Assertions.assertTrue(flag[0]);
    }

}