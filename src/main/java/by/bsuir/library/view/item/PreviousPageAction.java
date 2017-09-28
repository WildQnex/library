package by.bsuir.library.view.item;

import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;

public class PreviousPageAction extends PaginationActionView {

    private PaginationMenu paginationMenu;

    public PreviousPageAction(PaginationMenu paginationMenu) {
        super("", "Previous Page");
        this.paginationMenu = paginationMenu;
    }

    @Override
    public void executeCustomAction() {
        paginationMenu.previousPage();
    }
}
