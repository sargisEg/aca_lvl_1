package com.aca.homework.week12.stopwatch;

public enum DisplayType {

    SECONDS_AND_MILLIS {
        @Override
        public String getStringRepresentationOfMilliseconds(long milliseconds) {
            return milliseconds / 1000 + "." + milliseconds % 1000 + " sec";
        }
    },

    SECONDS {
        @Override
        public String getStringRepresentationOfMilliseconds(long milliseconds) {
            return milliseconds / 1000 + " sec";
        }
    };

    public abstract String getStringRepresentationOfMilliseconds(long milliseconds);
}
