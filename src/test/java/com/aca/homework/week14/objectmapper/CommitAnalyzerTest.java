package com.aca.homework.week14.objectmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommitAnalyzerTest {

    @Test
    public void testCount() {
        CommitAnalyzer testSubject = new CommitAnalyzer("commits-data.txt");
        Assertions.assertEquals(301, testSubject.count());
    }
}