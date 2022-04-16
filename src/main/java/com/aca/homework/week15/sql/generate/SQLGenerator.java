package com.aca.homework.week15.sql.generate;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class SQLGenerator {

    public String generateInsert(User user) {
        Table tableAnnotation = user.getClass().getDeclaredAnnotation(Table.class);
        if(tableAnnotation != null) {

            StringBuilder insertSQL = new StringBuilder("insert into ");

            insertSQL.append(tableAnnotation.name());
            insertSQL.append(" (");
            appendColumnNamesFromObject(insertSQL, user);
            insertSQL.append(") values (");
            appendColumnValuesFromObject(insertSQL, user);
            insertSQL.append(")");

            return insertSQL.toString();
        }

        return "";
    }

    private void appendColumnValuesFromObject(StringBuilder insertSQL, User object) {

        List<Field> fields = getAnnotatedFieldsFrom(object);

        fields.forEach(field -> {
            Object value;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (value instanceof String) {
                insertSQL.append("'");
                insertSQL.append(value);
                insertSQL.append("'");
            } else {
                insertSQL.append(value);
            }
            insertSQL.append(", ");
        });

        insertSQL.delete(insertSQL.length() - 2, insertSQL.length());
    }

    private void appendColumnNamesFromObject(StringBuilder insertSQL, User object) {

        List<Field> fields = getAnnotatedFieldsFrom(object);

        fields.forEach(field -> {
            insertSQL.append(field.getDeclaredAnnotation(Column.class).name());
            insertSQL.append(", ");
        });

        insertSQL.delete(insertSQL.length() - 2, insertSQL.length());
    }

    private List<Field> getAnnotatedFieldsFrom(User object) {

        List<Field> fields = new LinkedList<>();
        for (Field declaredField : object.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
            if (columnAnnotation != null) {
                fields.add(declaredField);
            }
        }

        return fields;
    }
}
