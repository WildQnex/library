package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

public class ListBooksByAuthorAction extends ActionView {

    private BookDao bookDao = new BookDaoImpl();

    public ListBooksByAuthorAction() {
        super("Book finder...", "Find book by author");
    }

    @Override
    public void executeCustomAction() {
        String bookAuthor = this.prompt("Enter book author: ", String.class);

        new Util<Book>().printListIfNotEmpty(bookDao.getBookByAuthor(bookAuthor), "No books were found");
    }
}
