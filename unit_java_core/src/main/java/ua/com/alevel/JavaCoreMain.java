package ua.com.alevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class JavaCoreMain {

    public static void main(String[] args) {

//        StaticClass staticClass = new StaticClass();
//        staticClass.test1();

        StaticClass.test2();

        System.out.println(" ua " + StaticClass.UA);


        Singleton singleton = Singleton.getInstance();
        singleton.write();

        Singleton singleton1 = Singleton.getInstance();

//        final Woman woman1 = new Woman();
//        woman1.setAge(10);
//
//        Woman woman2 = woman1;
//        woman2.setAge(15);
//
//        System.out.println("woman1 = " + woman1.getAge());
//
//
//        System.out.println("JavaCoreMain.main");
//        Man man1 = new Man();
//        man1.setAge(10);
//        man1.setName("test");
//        man1.setInn(12);
//
//        Man man2 = new Man();
//        man2.setAge(10);
//        man2.setName("test");
//        man2.setInn(13);
//
//        System.out.println("eq: " + man1.equals(man2));
//        System.out.println("hash: " + (man1.hashCode() == man2.hashCode()));
//
//        Date date = new Date();
//        System.out.println("date = " + date);
//
//        Class<? extends Man> aClass = man2.getClass();
//        System.out.println("aClass = " + aClass);
//        for (Field declaredField : aClass.getSuperclass().getDeclaredFields()) {
//            System.out.println("declaredField = " + declaredField);
//        }

        AQAA aqaa = new AQAA(10, "test");
        System.out.println("aqaa = " + aqaa);
        for (Field declaredField : aqaa.getClass().getDeclaredFields()) {
            if (declaredField.getType().isAssignableFrom(String.class)) {
                declaredField.setAccessible(true);
                try {
                    declaredField.set(aqaa, "ldhjfgasljdf");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Constructor<?> declaredConstructor : aqaa.getClass().getDeclaredConstructors()) {
//            declaredConstructor.newInstance()
        }

        for (Method declaredMethod : aqaa.getClass().getDeclaredMethods()) {

        }



        System.out.println("aqaa = " + aqaa);
    }
}
