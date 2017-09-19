package by.bsuir.library.view.console;

import io.bretty.console.view.MenuView;
import io.bretty.console.view.ViewConfig;

public class LibraryMenuView extends MenuView  {

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
            this.onQuit();
        }
    }
}
