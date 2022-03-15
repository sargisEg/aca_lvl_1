package com.aca.homework.week10.object.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServletRequestObjectFactoryTest {

    private ObjectFactory testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new ServletRequestObjectFactory();
    }

    @Test
    public void testSingleGetObject() {
        Assertions.assertNotEquals(null, testSubject.getObject());
    }

    @Test
    public void testGet2Objects() {
        ServletRequest testObject1 = (ServletRequest) testSubject.getObject();
        ServletRequest testObject2 = (ServletRequest) testSubject.getObject();
        Assertions.assertNotEquals(testObject1, testObject2);
    }

    @Test
    public void testGet3Objects() {
        ServletRequest testObject1 = (ServletRequest) testSubject.getObject();
        ServletRequest testObject2 = (ServletRequest) testSubject.getObject();
        ServletRequest testObject3 = (ServletRequest) testSubject.getObject();

        Assertions.assertNotEquals(testObject1, testObject2);
        Assertions.assertNotEquals(testObject1, testObject3);
        Assertions.assertNotEquals(testObject2, testObject3);
    }

}