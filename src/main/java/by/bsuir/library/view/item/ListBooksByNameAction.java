package by.bsuir.library.view.item;

import by.bsuir.library.dao.iml.BookDaoIml;
import by.bsuir.library.entity.Book;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

import java.util.List;

public class ListBooksByNameAction extends ActionView {

    public ListBooksByNameAction() {
        super("Book finder...", "Find book by name");
    }

    @Override
    public void executeCustomAction() {
        String bookName = this.prompt("Enter book name: ", String.class);

        new Util<Book>().printListIfNotEmpty(new BookDaoIml().getBookByName(bookName), "No books were found");
    }
}
