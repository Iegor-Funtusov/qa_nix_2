package ua.com.alevel;

import ua.com.alevel.controller.UserController;
import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class OOPMain {

    public static void main(String[] args) {

//        BaseEntity baseEntity = new BaseEntity();

        new UserController().start();

//        Class<? extends User> userClass = new User().getClass();
//        System.out.println("full name: " + userClass.getName());
//        System.out.println("full name: " + userClass.getSimpleName());
//
//        for (Field declaredField : userClass.getDeclaredFields()) {
//            System.out.println("declaredField = " + declaredField.getName());
//            System.out.println("declaredField = " + declaredField.getType());
//        }
//
//        try {
//            User user = userClass.getDeclaredConstructor().newInstance();
//            user.setAge(10);
//            System.out.println("user = " + user);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }


//        List<Audi> audis = new ArrayList<>();
//        audis.add(new AudiQ3());
//        audis.add(new AudiQ5());
//        audis.add(new AudiQ7());
//
//        for (Audi audi : audis) {
//            audi.drive();
//        }
    }
}
