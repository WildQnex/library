package by.bsuir.library.view.item;

import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;

public class NextPageAction extends PaginationActionView {

    private PaginationMenu paginationMenu;

    public NextPageAction(PaginationMenu paginationMenu) {
        super("", "Next Page");
        this.paginationMenu = paginationMenu;
    }

    @Override
    public void executeCustomAction() {
        paginationMenu.nextPage();
    }
}
