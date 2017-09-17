package by.bsuir.library.dao.iml;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoIml implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(BookDaoIml.class);

    public UserDaoIml() {

    }


    @Override
    public List<User> getAll() {
        return Cache.getInstance().getUsers();
    }

    @Override
    public void createUser(User user) {
        Cache.getInstance().getUsers().add(user);
    }
}