package by.bsuir.library.view.item;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.entity.Role;
import io.bretty.console.view.ActionView;

public class GiveAdminRightsAction extends ActionView {

    private UserDao  userDao = new UserDaoImpl();

    public GiveAdminRightsAction() {
        super("Choose User", "Give admin rights");
    }


    @Override
    public void executeCustomAction() {
        userDao.getUserById(this.prompt("Enter User ID: ", Long.class)).setRole(Role.ADMIN);
    }
}
