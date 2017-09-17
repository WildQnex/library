package by.bsuir.library.dao;

import by.bsuir.library.entity.User;
import java.util.List;

public interface UserDao {
    List<User> getAll();
    void createUser(User user);
    long getLastId();
}
