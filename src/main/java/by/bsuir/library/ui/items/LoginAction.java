package by.bsuir.library.ui.items;

import io.bretty.console.view.ActionView;

public class LoginAction extends ActionView {

    public LoginAction() {
        super("Signing In", "Sign In");
    }

    @Override
    public void executeCustomAction() {
        this.prompt("Enter an integer", Integer.class);
    }
}
