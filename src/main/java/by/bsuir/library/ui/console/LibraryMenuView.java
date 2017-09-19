package by.bsuir.library.ui.console;

import io.bretty.console.view.MenuView;

public class LibraryMenuView extends MenuView  {

    public LibraryMenuView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
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
