package com.aca.homework.week10.enums.list;

import java.util.Collections;
import java.util.List;

public enum PhoneModel {

    NOKIA_1100 (Collections.emptyList()) {
        @Override
        public List<String> getCameraDescriptionList() {
            return getCameraDescription();
        }
    },
    NOKIA_3110 (Collections.singletonList("back camera")){
        @Override
        public List<String> getCameraDescriptionList() {
            return getCameraDescription();
        }
    },
    GALAXY_S2 (List.of("back camera", "front camera")){
        @Override
        public List<String> getCameraDescriptionList() {
            return getCameraDescription();
        }
    };

    private List<String> cameraDescription;

    PhoneModel(List<String> cameraDescription) {
        this.cameraDescription = cameraDescription;
    }

    public List<String> getCameraDescription() {
        return cameraDescription;
    }

    public abstract List<String> getCameraDescriptionList();
}
