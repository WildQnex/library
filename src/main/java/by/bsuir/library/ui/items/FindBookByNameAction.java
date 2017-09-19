package by.bsuir.library.ui.items;

import by.bsuir.library.dao.iml.BookDaoIml;
import io.bretty.console.view.ActionView;

public class FindBookByNameAction extends ActionView {

    public FindBookByNameAction() {
        super("Book finder...", "Find book by name");
    }

    @Override
    public void executeCustomAction() {
        System.out.println(new BookDaoIml().getBookByName(this.prompt("Enter book name", String.class)));
    }
}
