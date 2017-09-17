package by.bsuir.library.dao;

import by.bsuir.library.entity.User;
import java.util.ArrayList;

public interface UserDao {
    ArrayList<User> readUsers();
    void rewriteUsers(ArrayList<User> books);
}
