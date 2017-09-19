package by.bsuir.library.view.items;

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
            Menu.getInstance().displayAdminMenu();
        }
    }
}
