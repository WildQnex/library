package by.bsuir.library.ui;

import by.bsuir.library.ui.items.LoginAction;
import by.bsuir.library.ui.items.RegisterAction;
import io.bretty.console.view.MenuView;

public class Menu {

        public static MenuView rootMenu = new MenuView("Welcome...", "");

        static {
            MenuView xepPoimyKakNazvatEgoMenu = new MenuView("Menu xep poimy kakoe", "XEP");
            xepPoimyKakNazvatEgoMenu.addMenuItem(new RegisterAction());

            rootMenu.addMenuItem(new LoginAction());
            rootMenu.addMenuItem(new RegisterAction());
            rootMenu.addMenuItem(xepPoimyKakNazvatEgoMenu);
        }


}
