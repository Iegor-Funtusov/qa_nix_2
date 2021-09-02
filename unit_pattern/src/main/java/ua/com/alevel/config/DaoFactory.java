package ua.com.alevel.config;

import ua.com.alevel.dao.CsvUserDao;
import ua.com.alevel.dao.JsonUserDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;
    private UserDao userDao;
    private DaoType daoType;

    private DaoFactory() { }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public UserDao getUserDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (userDao == null) {
                    userDao = new CsvUserDao();
                }
            } break;
            case JSON : {
                if (userDao == null) {
                    userDao = new JsonUserDao();
                }
            } break;
        }
        return userDao;
    }
}
