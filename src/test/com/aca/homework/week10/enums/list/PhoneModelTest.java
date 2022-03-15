package com.aca.homework.week10.enums.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneModelTest {

    @Test
    public void testNokia1100CameraDescriptionList() {
        Assertions.assertEquals(0, PhoneModel.NOKIA_1100.getCameraDescriptionList().size());
    }

    @Test
    public void testNokia3110CameraDescriptionList() {
        Assertions.assertEquals(1, PhoneModel.NOKIA_3110.getCameraDescriptionList().size());
        Assertions.assertEquals("back camera", PhoneModel.NOKIA_3110.getCameraDescriptionList().get(0));
    }

    @Test
    public void testGalaxyS2CameraDescriptionList() {
        Assertions.assertEquals(2, PhoneModel.GALAXY_S2.getCameraDescriptionList().size());
        Assertions.assertEquals("back camera", PhoneModel.GALAXY_S2.getCameraDescriptionList().get(0));
        Assertions.assertEquals("front camera", PhoneModel.GALAXY_S2.getCameraDescriptionList().get(1));
    }

}