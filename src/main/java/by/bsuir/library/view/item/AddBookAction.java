package by.bsuir.library.view.item;

import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import io.bretty.console.view.ActionView;

public class AddBookAction extends ActionView{
    public AddBookAction() {
        super("Adding book...", "Add book");
    }

    @Override
    public void executeCustomAction() {
        new BookDaoImpl().createBook(new Book(this.prompt("Enter book name", String.class), this.prompt("Enter book name", String.class)));
    }
}
