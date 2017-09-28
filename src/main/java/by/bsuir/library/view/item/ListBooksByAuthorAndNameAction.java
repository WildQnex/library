package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.view.console.PaginationActionView;
import by.bsuir.library.view.console.PaginationMenu;

public class ListBooksByAuthorAndNameAction extends PaginationActionView {
    private BookDao bookDao = new BookDaoImpl();

    public ListBooksByAuthorAndNameAction() {
        super("", "Find book by author and name");
    }

    @Override
    public void executeCustomAction() {
        String bookAuthor = this.prompt("Enter book author: ", String.class);
        String bookName = this.prompt("Enter book name: ", String.class);

        new PaginationMenu("Book finder...", bookDao.getBookByAuthorAndName(bookAuthor, bookName), 5, "No books were found").display();
    }
}
