package by.bsuir.library.dao.iml;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

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

    @Override
    public long getLastId() {
        List<User> users = Cache.getInstance().getUsers();

        return users.stream()
                .max((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .orElse(new User(0L))
                .getId();
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> users = Cache.getInstance().getUsers();

        return users.stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUserByMail(String mail) {
        List<User> users = Cache.getInstance().getUsers();

        return users.stream()
                .filter(user -> user.getMail().equals(mail))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUserByMailAndName(String mail, String name) {
        List<User> users = Cache.getInstance().getUsers();

        return users.stream()
                .filter(user -> user.getMail().equals(mail) && user.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(long id) {
        List<User> users = Cache.getInstance().getUsers();
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(new User(0L));
    }
}