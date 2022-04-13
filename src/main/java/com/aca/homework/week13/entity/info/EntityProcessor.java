package com.aca.homework.week13.entity.info;

import com.aca.homework.week13.entity.info.annotations.Column;
import com.aca.homework.week13.entity.info.annotations.Entity;
import com.aca.homework.week13.entity.info.annotations.Id;
import com.aca.homework.week13.entity.info.annotations.Table;

import java.lang.reflect.Field;
import java.util.function.Consumer;

public class EntityProcessor {

    private final Consumer<String> consumer;

    public EntityProcessor(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void printInfo(Object o) {
        StringBuilder info = new StringBuilder();
        if (o.getClass().isAnnotationPresent(Entity.class)) {
            info.append("table name is: ");
            info.append(getTableNameIfExist(o));
            info.append(", ID is: ");
            info.append(getIdIfExist(o));
            info.append(getColumns(o));
        }
        consumer.accept(info.toString());
    }

    private String getColumns(Object o) {
        StringBuilder columns = new StringBuilder(", ");
        for (Field field : o.getClass().getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                columns.append(column.name());
                columns.append(" is: ");
                columns.append(value);
                columns.append(", ");
            }
        }
        columns.delete(columns.length() - 2, columns.length());
        return columns.toString();
    }

    private long getIdIfExist(Object o) {
        for (Field field : o.getClass().getDeclaredFields()) {
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                field.setAccessible(true);
                try {
                    return (Long) field.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0L;
    }

    private String getTableNameIfExist(Object o) {
        Table tableAnnotation = o.getClass().getDeclaredAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        }
        return "";
    }
}
