package com.nixsolutions.configure.configurator.impl;

import com.nixsolutions.ApplicationContext;
import com.nixsolutions.annotations.InjectBean;
import com.nixsolutions.configure.configurator.ObjectConfigurator;

import java.lang.reflect.Field;

public class InjectBeanObjectConfigurator implements ObjectConfigurator {

    @Override
    public void configure(Object o, ApplicationContext context) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectBean.class)) {
                declaredField.setAccessible(true);
                Object impl = context.getObjectImpl(declaredField.getType());
                try {
                    declaredField.set(o, impl);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("problem from initial field");
                }
            }
        }
    }
}
