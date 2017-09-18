package by.bsuir.library.dao;

import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;
import java.util.List;

public interface UserDao {
    List<User> getAll();
    void createUser(User user);
    long getLastId();
    List<User> getUserByName(String name);
    List<User> getUserByMail(String mail);
    List<User> getUserByMailAndName(String mail, String name);
    User getUserById(long id);
}
