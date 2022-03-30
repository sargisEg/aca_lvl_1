package com.aca.homework.week12.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;

public class ObjectJsonProcessor {

    public String process(Object o) {
        StringBuilder json = new StringBuilder("{");

        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            JsonProperty annotation = declaredField.getAnnotation(JsonProperty.class);
            if(annotation != null) {
                String key = annotation.value();
                json.append("\"" + key + "\": \"");
                declaredField.setAccessible(true);
                try {
                    json.append(declaredField.get(o));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                json.append("\", ");
            }
        }

        json.delete(json.length() - 2, json.length());
        return json.append("}").toString();
    }

}
