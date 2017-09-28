package by.bsuir.library.view.item;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;
public class ListAllUsersAction extends PaginationActionView {

    private UserDao userDao = new UserDaoImpl();

    public ListAllUsersAction() {
        super("", "Show users list");
    }

    @Override
    public void executeCustomAction() {
        new PaginationMenu("Users List", userDao.getAll(), 5, "No books were found").display();
    }
}
