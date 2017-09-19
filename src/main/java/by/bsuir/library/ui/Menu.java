package by.bsuir.library.ui;

import by.bsuir.library.ui.console.LibraryMenuView;
import by.bsuir.library.ui.items.AddBookAction;
import by.bsuir.library.ui.items.FindBookByNameAction;
import by.bsuir.library.ui.items.LoginAction;
import by.bsuir.library.ui.items.RegisterAction;

public class Menu {

        public static LibraryMenuView rootMenu = new LibraryMenuView("Welcome...", "");
        public static LibraryMenuView userMenu = new LibraryMenuView("Choose action", "");
        public static LibraryMenuView adminMenu = new LibraryMenuView("Choose action: ", "");

        static {
            adminMenu.addMenuItem(new FindBookByNameAction());
            adminMenu.addMenuItem(new AddBookAction());

            rootMenu.addMenuItem(new LoginAction());
            rootMenu.addMenuItem(new RegisterAction());
        }


}
