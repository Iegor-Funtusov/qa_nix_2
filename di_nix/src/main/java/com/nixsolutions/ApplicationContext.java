package com.nixsolutions;

import com.nixsolutions.annotations.BeanClass;
import com.nixsolutions.factory.ObjectFactory;
import com.nixsolutions.util.ClassLoaderUtil;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationContext {

    private final Map<Class<?>, Object> mapInterfaceAndImplementation = new HashMap<>();
    private Set<Class<?>> interfaces;
    private ClassLoader mainClassLoader;
    private ApplicationSearcher applicationSearcher;
    private Reflections scanner;
    private ObjectFactory objectFactory;

    public ApplicationContext(Class<?> mainClass) {
        try {
            Package mainPackage = mainClass.getPackage();
            String basePackage = mainPackage.getName();
            ClassLoader mainClassLoader = mainClass.getClassLoader();
            List<Class<?>> allClasses = ClassLoaderUtil.getClasses(basePackage);
            Set<Class<?>> interfaces = allClasses.stream().filter(Class::isInterface).collect(Collectors.toSet());
            this.interfaces = initOnlyInterfacesClasses(interfaces);
            this.applicationSearcher = new ApplicationSearcher(basePackage);
            this.scanner = new Reflections(this.getClass().getPackage().getName());
            this.mainClassLoader = mainClassLoader;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    public void init() {
        initMapInterfaceAndImplementation();
    }

    public Map<Class<?>, Object> getMapInterfaceAndImplementation() {
        return mapInterfaceAndImplementation;
    }

    private void initMapInterfaceAndImplementation() {
        for (Class<?> serviceInterface : this.interfaces) {
            getObjectImpl(serviceInterface);
        }
    }

    public  <I> I getObjectImpl(Class<I> type) {
        Class<? extends I> impl = type;
        if (mapInterfaceAndImplementation.containsKey(type)) {
            return (I) mapInterfaceAndImplementation.get(type);
        }
        if (type.isInterface()) {
            impl = this.applicationSearcher.getImplementation(type);
        }
        I i = objectFactory.createObject(impl);
        if (impl.isAnnotationPresent(BeanClass.class)) {
            mapInterfaceAndImplementation.put(type, i);
        }
        return i;
    }

    public Reflections getScanner() {
        return scanner;
    }

    public ClassLoader getMainClassLoader() {
        return mainClassLoader;
    }

    private Set<Class<?>> initOnlyInterfacesClasses(Set<Class<?>> interfaces) {
        return interfaces
                .stream()
                .filter(this::isServiceClass)
                .collect(Collectors.toSet());
    }

    private boolean isServiceClass(Class<?> currentInterface) {
        return currentInterface.getSimpleName().endsWith(ApplicationStandard.SERVICE_CLASS_DAO.getApplicationsParam()) ||
                currentInterface.getSimpleName().endsWith(ApplicationStandard.SERVICE_CLASS_SERVICE.getApplicationsParam()) ||
                currentInterface.getSimpleName().endsWith(ApplicationStandard.SERVICE_CLASS_FACADE.getApplicationsParam()) ||
                currentInterface.getSimpleName().endsWith(ApplicationStandard.SERVICE_CLASS_CONTROLLER.getApplicationsParam());
    }
}
