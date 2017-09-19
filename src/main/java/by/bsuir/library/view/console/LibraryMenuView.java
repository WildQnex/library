package by.bsuir.library.view.console;

import by.bsuir.library.view.Menu;
import io.bretty.console.view.MenuView;
import io.bretty.console.view.ViewConfig;

import java.util.Map;

public class LibraryMenuView extends MenuView {

    public LibraryMenuView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
    }

    public LibraryMenuView(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        super(runningTitle, nameInParentMenu, viewConfig);
    }

    @Override
    protected void goBack() {
        if (this.parentView != null) {
            this.onBack();
            if (this.parentView instanceof MenuView) {
                this.parentView.display();
            }
        } else {
            Menu.loggedUser = null;
            this.onQuit();
        }
    }

    @Override
    public void display() {
        if (Menu.loggedUser != null) {
            this.println("\nUser: " + Menu.loggedUser.getName() + " | Role: " + Menu.loggedUser.getRole());
        }
        super.display();
    }
}
