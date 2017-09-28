package by.bsuir.library.view.console;

import io.bretty.console.view.ActionView;

public class PaginationActionView extends ActionView {
    public PaginationActionView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
    }

    @Override
    public void display() {
        this.println();
        this.println(this.runningTitle);
        this.executeCustomAction();
        this.goBack();
    }

    @Override
    public void executeCustomAction() {

    }

}
