package com.aca.homework.week10.enums.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PhoneModelTest {

    @Test
    public void testNokia1100CameraDescriptionList() {
        Assertions.assertEquals(0, PhoneModel.NOKIA_1100.getCameraDescriptionList().size());
    }

    @Test
    public void testNokia3110CameraDescriptionList() {
        List<String> testList = PhoneModel.NOKIA_3110.getCameraDescriptionList();
        Assertions.assertEquals(1, testList.size());
        Assertions.assertEquals("back camera", testList.get(0));
    }

    @Test
    public void testGalaxyS2CameraDescriptionList() {
        List<String> testList = PhoneModel.GALAXY_S2.getCameraDescriptionList();
        Assertions.assertEquals(2, testList.size());
        Assertions.assertEquals("back camera", testList.get(0));
        Assertions.assertEquals("front camera", testList.get(1));
    }

}