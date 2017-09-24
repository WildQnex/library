package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

public class ListBooksByAuthorAndName extends ActionView {
    private BookDao bookDao = new BookDaoImpl();

    public ListBooksByAuthorAndName() {
        super("Book finder...", "Find book by author and name");
    }

    @Override
    public void executeCustomAction() {
        String bookAuthor = this.prompt("Enter book author: ", String.class);
        String bookName = this.prompt("Enter book name: ", String.class);

        new Util<Book>().printListIfNotEmpty(bookDao.getBookByAuthorAndName(bookAuthor, bookName), "No books were found");
    }
}
