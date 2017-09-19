package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

public class ListBooksByNameAction extends ActionView {

    private BookDao bookDao = new BookDaoImpl();

    public ListBooksByNameAction() {
        super("Book finder...", "Find book by name");
    }

    @Override
    public void executeCustomAction() {
        String bookName = this.prompt("Enter book name: ", String.class);

        new Util<Book>().printListIfNotEmpty(bookDao.getBookByName(bookName), "No books were found");
    }
}
