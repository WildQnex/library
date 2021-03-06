package by.bsuir.library.util;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.dao.impl.UserDaoImpl;

public class IdGenerator {

    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    private IdGenerator() {
    }

    public static IdGenerator getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public long nextBookId(){
        return bookDao.getLastId() + 1;
    }

    public long nextUserId(){
        return userDao.getLastId() + 1;
    }

    private static class SingletonHolder{
        private static final IdGenerator INSTANCE;
        static {
            try {
                INSTANCE = new IdGenerator();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
