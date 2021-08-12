package ua.com.alevel.config;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final Reflections reflections = new Reflections("ua.com.alevel");

    private ObjectFactory() {}

    public static ObjectFactory getObjectFactory() {
        return OBJECT_FACTORY;
    }

    public <DAO> DAO getImplClassByInterface(Class<DAO> aClass) {
        Set<Class<? extends DAO>> daos = reflections.getSubTypesOf(aClass);
        for (Class<? extends DAO> dao : daos) {
            if (!dao.isAnnotationPresent(Ignore.class)) {
                try {
                    return dao.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("ВСЕ ПЛОХО!!!");
    }
}
