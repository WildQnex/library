package by.bsuir.library.main;

import by.bsuir.library.dao.iml.BookDaoIml;
import by.bsuir.library.dao.iml.UserDaoIml;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Vadim","Vadim", "Vadim", 1));
        users.add(new User("Nikita","Nick", "Vadim", 0));
        UserDaoIml dao = new UserDaoIml();
        dao.rewriteUsers(users);
        users = dao.readUsers();
        LOGGER.debug(users);

    }
}
