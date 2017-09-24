package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import io.bretty.console.view.ActionView;

public class BookByIDAction extends ActionView{
    private BookDao bookDao = new BookDaoImpl();

    public BookByIDAction() {
        super("Book finder...", "Find book by ID");
    }

    @Override
    public void executeCustomAction() {
        long bookID = this.prompt("Enter book ID: ", Long.class);

        Book book = bookDao.getBookById(bookID);

        if(book != null){
            this.println(book);
        } else {
            this.println("No books were found");
        }
    }
}
