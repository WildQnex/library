package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

public class ListAllBooksAction extends ActionView{

    private BookDao bookDao = new BookDaoImpl();


    public ListAllBooksAction() {
        super("Books List", "Show books list");
    }

    @Override
    public void executeCustomAction() {
        new Util<Book>().printListIfNotEmpty(bookDao.getAll(), "No books were found");
    }
}
