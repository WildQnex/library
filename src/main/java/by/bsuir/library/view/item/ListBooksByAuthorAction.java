package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;

public class ListBooksByAuthorAction extends PaginationActionView {

    private BookDao bookDao = new BookDaoImpl();

    public ListBooksByAuthorAction() {
        super("", "Find book by author");
    }

    @Override
    public void executeCustomAction() {
        String bookAuthor = this.prompt("Enter book author: ", String.class);

        new PaginationMenu("Book finder...", bookDao.getBookByAuthor(bookAuthor), 5, "No books were found").display();
    }
}
