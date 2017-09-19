package by.bsuir.library.view.item;

import by.bsuir.library.dao.iml.BookDaoIml;
import by.bsuir.library.entity.Book;
import by.bsuir.library.util.Util;
import io.bretty.console.view.ActionView;

import java.util.List;

public class ListAllBooksAction extends ActionView{

    public ListAllBooksAction() {
        super("Books List", "Show books list");
    }

    @Override
    public void executeCustomAction() {
        new Util<Book>().printListIfNotEmpty(new BookDaoIml().getAll(), "No books were found");
    }
}
