package com.aca.homework.week11.jackson.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class AddressTest {

    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address();
    }

    @Test
    public void testCountryFieldAnnotation() throws NoSuchFieldException {
        Field field = address.getClass().getDeclaredField("country");
        Assertions.assertNotNull(field.getDeclaredAnnotation(JsonProperty.class));
        Assertions.assertEquals("jsonFieldCountry", field.getDeclaredAnnotation(JsonProperty.class).value());
    }

    @Test
    public void testCityFieldAnnotation() throws NoSuchFieldException {
        Field field = address.getClass().getDeclaredField("city");
        Assertions.assertNotNull(field.getDeclaredAnnotation(JsonProperty.class));
        Assertions.assertEquals("jsonFieldCity", field.getDeclaredAnnotation(JsonProperty.class).value());
    }

    @Test
    public void testStreetFieldAnnotation() throws NoSuchFieldException {
        Field field = address.getClass().getDeclaredField("street");
        Assertions.assertNotNull(field.getDeclaredAnnotation(JsonProperty.class));
        Assertions.assertEquals("jsonFieldStreet", field.getDeclaredAnnotation(JsonProperty.class).value());
    }

}