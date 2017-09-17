package by.bsuir.library.main;


import by.bsuir.library.cache.Cache;
import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.iml.BookDaoIml;
import by.bsuir.library.dao.iml.UserDaoIml;
import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.Role;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;
import java.util.List;


public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        try (Cache cache = Cache.getInstance()) {

            UserDao userDao = new UserDaoIml();
            BookDao bookDao = new BookDaoIml();

            userDao.createUser(new User("Vadim", "Vadim", "654", Role.ADMIN));
            userDao.createUser(new User("Nick", "Vadim", "346", Role.USER));

            bookDao.createBook(new Book("KNIGA1", "AUTHOR1"));
            bookDao.createBook(new Book("KNIGA2", "AUTHOR2"));

            List<User> users = userDao.getAll();
            LOGGER.debug(users);

            List<Book> books = bookDao.getAll();
            LOGGER.debug(books);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
