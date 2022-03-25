package com.aca.homework.week12.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DisplayTypeTest {

    @Test
    public void testWhenTypeIsSeconds() {
        DisplayType testSubject = DisplayType.SECONDS;
        Assertions.assertEquals("36 sec", testSubject.getStringRepresentationOfMilliseconds(36542));
    }

    @Test
    public void testWhenTypeIsSecondsAndMillis() {
        DisplayType testSubject = DisplayType.SECONDS_AND_MILLIS;
        Assertions.assertEquals("36 sec  542 milSec", testSubject.getStringRepresentationOfMilliseconds(36542));
    }
}