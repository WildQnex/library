package by.bsuir.library.view.item;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.entity.Role;
import by.bsuir.library.entity.User;
import by.bsuir.library.view.Menu;
import io.bretty.console.view.ActionView;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Optional;

public class LoginAction extends ActionView {

    private UserDao userDao = new UserDaoImpl();

    public LoginAction() {
        super("Signing In", "Sign In");
    }

    @Override
    public void executeCustomAction() {
        String mail = this.prompt("Enter Your mail: ", String.class);
        String password = this.prompt("Enter an Your password: ", String.class);

        Optional<User> optionalUser = userDao.getAll()
                .parallelStream()
                .filter(u -> mail.equals(u.getMail()))
                .filter(u -> BCrypt.checkpw(password, u.getPassHash()))
                .findAny();

        if (optionalUser.isPresent()) {
            Menu.loggedUser = optionalUser.get();
            if (Menu.loggedUser.getRole() == Role.ADMIN) {
                Menu.getInstance().displayAdminMenu();
            } else {
                Menu.getInstance().displayUserMenu();
            }
        } else {
            this.println("Wrong mail or password");
        }
    }
}
