package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.view.console.PaginationMenu;
import io.bretty.console.view.ActionView;

import java.util.List;

public class BookByIdAction extends ActionView{

    private BookDao bookDao = new BookDaoImpl();

    public BookByIdAction() {
        super("Book finder...", "Find book by ID");
    }

    @Override
    public void executeCustomAction() {
        long bookId = this.prompt("Enter book ID: ", Long.class);

        List<Book> book = bookDao.getBookById(bookId);

        new PaginationMenu("Book finder...", book, 5, "No books were found").display();

    }
}
