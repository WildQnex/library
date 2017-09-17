package by.bsuir.library.main;

import by.bsuir.library.dao.FileReader;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Vadim","Vadim", "Vadim", 1));
        users.add(new User("Nikita","Nick", "Vadim", 0));
        FileReader.rewriteUsers(users);
        users = FileReader.readAllUsers();
        LOGGER.debug(users);

    }
}
