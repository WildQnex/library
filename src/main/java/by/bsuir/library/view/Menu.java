package by.bsuir.library.view;

import by.bsuir.library.entity.User;
import by.bsuir.library.view.console.LibraryMenuView;
import by.bsuir.library.view.item.*;
import io.bretty.console.view.MenuView;
import io.bretty.console.view.ViewConfig;

public class Menu {

    public static User loggedUser;

    private ViewConfig authViewConfig = new ViewConfig.Builder()
            .setQuitMenuName("Logout")
            .setQuitMessage("Logging out...")
            .build();

    private LibraryMenuView rootMenu = new LibraryMenuView("Welcome...", "");
    private LibraryMenuView finderMenu = new LibraryMenuView("Choose finder type", "Book finder");
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

    public void displayUserMenu(){
        userMenu.display();
    }

    private void init() {
        finderMenu.addMenuItem(new ListAllBooksAction());
        finderMenu.addMenuItem(new ListBooksByAuthorAction());
        finderMenu.addMenuItem(new ListBooksByNameAction());
        finderMenu.addMenuItem(new ListBooksByAuthorAndName());
        finderMenu.addMenuItem(new BookByIDAction());


        userMenu.addMenuItem(finderMenu);

        adminMenu.addMenuItem(finderMenu);
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
