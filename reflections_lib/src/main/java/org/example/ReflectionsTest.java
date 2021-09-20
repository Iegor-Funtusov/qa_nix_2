package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionsTest {

    public static void info(Class<?> aClass) {
        System.out.println("aClass = " + aClass);
        Package aPackage = aClass.getPackage();
        System.out.println("aPackage = " + aPackage);
        String fullName = aClass.getName();
        System.out.println("fullName = " + fullName);
        String simpleName = aClass.getSimpleName();
        System.out.println("simpleName = " + simpleName);
        Class<?> superclass = aClass.getSuperclass();
        System.out.println("superclass = " + superclass);
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
        System.out.println();
        for (Method declaredMethod : declaredMethods) {
            if (!declaredMethod.isAnnotationPresent(CustomOverride.class)) {
                System.out.println("declaredMethod = " + declaredMethod);
            }
        }
        System.out.println();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getType().isAssignableFrom(String.class)) {
                System.out.println("declaredField = " + declaredField);
                declaredField.setAccessible(true);
                try {
                    declaredField.set(aClass, "test@gmail.com");
//                    Object o = declaredField.get(aClass);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
