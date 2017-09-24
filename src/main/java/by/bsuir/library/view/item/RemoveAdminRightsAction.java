package by.bsuir.library.view.item;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.entity.Role;
import io.bretty.console.view.ActionView;

public class RemoveAdminRightsAction extends ActionView {

    private UserDao userDao = new UserDaoImpl();

    public RemoveAdminRightsAction() {
        super("Choose User", "Remove admin rights");
    }


    @Override
    public void executeCustomAction() {
        userDao.getUserById(this.prompt("Enter User ID: ", Long.class)).setRole(Role.USER);
    }
}
