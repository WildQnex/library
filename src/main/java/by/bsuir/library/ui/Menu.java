package by.bsuir.library.ui;

import by.bsuir.library.ui.items.AddBookAction;
import by.bsuir.library.ui.items.LoginAction;
import by.bsuir.library.ui.items.FindBookByNameAction;
import by.bsuir.library.ui.items.RegisterAction;
import io.bretty.console.view.MenuView;

public class Menu {

        public static MenuView rootMenu = new MenuView("Welcome...", "");
        public static MenuView userMenu = new MenuView("Choose action", "");
        public static MenuView adminMenu = new MenuView("Choose action: ", "");

        static {
            adminMenu.addMenuItem(new FindBookByNameAction());
            adminMenu.addMenuItem(new AddBookAction());

            rootMenu.addMenuItem(new LoginAction());
            rootMenu.addMenuItem(new RegisterAction());
        }


}
