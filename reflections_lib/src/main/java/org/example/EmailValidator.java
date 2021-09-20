package org.example;

import java.lang.reflect.Field;

public class EmailValidator {

    public static void validate(Class<?> aClass) {

//        try {
//            Field field = aClass.getDeclaredField("email");
//            field.setAccessible(true);
//            String o = (String) field.get(aClass);
//            System.out.println("field = " + field);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getType().isAssignableFrom(String.class)) {
                if (declaredField.getName().equals("email")) {
                    System.out.println("declaredField = " + declaredField);
                    try {
                        declaredField.setAccessible(true);
                        System.out.println("declaredField = " + declaredField.getName());
                        String o = (String) declaredField.get(aClass);
//                    System.out.println("email = " + email);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
