package by.bsuir.library.view.item;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

public class ListAllUsersAction extends ActionView {

    private UserDao userDao = new UserDaoImpl();

    public ListAllUsersAction() {
        super("Users List", "Show users list");
    }

    @Override
    public void executeCustomAction() {
        new Util<User>().printListIfNotEmpty(userDao.getAll(), "No users were found");
    }
}
