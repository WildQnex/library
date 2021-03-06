package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;

public class ListBooksByNameAction extends PaginationActionView {

    private BookDao bookDao = new BookDaoImpl();

    public ListBooksByNameAction() {
        super("", "Find book by name");
    }

    @Override
    public void executeCustomAction() {
        String bookName = this.prompt("Enter book name: ", String.class);

        new PaginationMenu("Book finder...", bookDao.getBookByName(bookName), 5, "No books were found").display();
    }
}
