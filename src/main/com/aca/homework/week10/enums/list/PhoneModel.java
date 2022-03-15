package com.aca.homework.week10.enums.list;

import java.util.Collections;
import java.util.List;

public enum PhoneModel {

    NOKIA_1100 {
        @Override
        public List<String> getCameraDescriptionList() {
            return Collections.emptyList();
        }
    },
    NOKIA_3110 {
        @Override
        public List<String> getCameraDescriptionList() {
            return Collections.singletonList("back camera");
        }
    },
    GALAXY_S2 {
        @Override
        public List<String> getCameraDescriptionList() {
            return List.of("back camera", "front camera");
        }
    };

    public abstract List<String> getCameraDescriptionList();
}
