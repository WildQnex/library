package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;

public class ListAllBooksAction extends PaginationActionView {

    private BookDao bookDao = new BookDaoImpl();


    public ListAllBooksAction() {
        super("Books List", "Show books list");
    }

    @Override
    public void executeCustomAction() {
        new PaginationMenu("Books List", bookDao.getAll(), 5, "No books were found").display();
    }
}
