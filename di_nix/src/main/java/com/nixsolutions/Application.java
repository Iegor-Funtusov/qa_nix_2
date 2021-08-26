package com.nixsolutions;

import com.nixsolutions.factory.ObjectFactory;

import java.util.Collection;
import java.util.Map;

public class Application {

    public static void start(Class<?> mainClass) {
        ApplicationContext context = new ApplicationContext(mainClass);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setObjectFactory(objectFactory);
        context.init();
        Map<Class<?>, Object> mapInterfaceAndImplementation = context.getMapInterfaceAndImplementation();
        Collection<Object> controllers = mapInterfaceAndImplementation.values();
        ApplicationStarter applicationStarter = new ApplicationStarter(controllers);
        applicationStarter.start();
    }
}
