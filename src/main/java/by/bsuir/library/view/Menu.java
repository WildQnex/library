package by.bsuir.library.view;

import by.bsuir.library.view.console.LibraryMenuView;
import by.bsuir.library.view.items.AddBookAction;
import by.bsuir.library.view.items.FindBookByNameAction;
import by.bsuir.library.view.items.LoginAction;
import by.bsuir.library.view.items.RegisterAction;
import io.bretty.console.view.ViewConfig;

public class Menu {
    private ViewConfig authViewConfig = new ViewConfig.Builder()
            .setQuitMenuName("Logout")
            .setQuitMessage("Logging out...")
            .build();

    private LibraryMenuView rootMenu = new LibraryMenuView("Welcome...", "");
    private LibraryMenuView userMenu = new LibraryMenuView("Choose action", "", authViewConfig);
    private LibraryMenuView adminMenu = new LibraryMenuView("Choose action: ", "", authViewConfig);

    private Menu() {
        init();
    }

    public static Menu getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void displayMainMenu(){
        rootMenu.display();
    }

    public void displayAdminMenu(){
        adminMenu.display();
    }

    private void init() {
        adminMenu.addMenuItem(new FindBookByNameAction());
        adminMenu.addMenuItem(new AddBookAction());

        rootMenu.addMenuItem(new LoginAction());
        rootMenu.addMenuItem(new RegisterAction());
    }

    private static class SingletonHolder{
        private static final Menu INSTANCE;
        static {
                INSTANCE = new Menu();
        }
    }
}
