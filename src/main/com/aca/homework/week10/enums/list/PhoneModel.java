package com.aca.homework.week10.enums.list;

import java.util.Collections;
import java.util.List;

public enum PhoneModel {

    NOKIA_1100(Collections.emptyList()),
    NOKIA_3110(Collections.singletonList("back camera")),
    GALAXY_S2(List.of("back camera", "front camera"));

    private final List<String> cameraDescription;

    PhoneModel(List<String> cameraDescription) {
        this.cameraDescription = cameraDescription;
    }

    public List<String> getCameraDescriptionList() {
        return cameraDescription;
    }
}
