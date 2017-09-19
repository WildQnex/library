package by.bsuir.library.view.item;

import by.bsuir.library.entity.Role;
import by.bsuir.library.entity.User;
import by.bsuir.library.view.Menu;
import io.bretty.console.view.ActionView;

public class LoginAction extends ActionView {

    public LoginAction() {
        super("Signing In", "Sign In");
    }

    @Override
    public void executeCustomAction() {
        String mail = this.prompt("Enter Your mail: ", String.class);
        String password = this.prompt("Enter an Your password: ", String.class);
        if(mail.equals("admin") && password.equals("admin")){
            Menu.loggedUser = new User("admin", "adminmail", "hash", Role.ADMIN, 0L);
            Menu.getInstance().displayAdminMenu();
        } else{
            Menu.loggedUser = new User("user", "usermail", "hash", Role.USER, 0L);
            Menu.getInstance().displayUserMenu();
        }
    }
}
