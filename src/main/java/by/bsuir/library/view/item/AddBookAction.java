package by.bsuir.library.view.item;

import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.BookType;
import io.bretty.console.view.ActionView;

import java.util.regex.Pattern;

public class AddBookAction extends ActionView{

    private static final Pattern BOOK_TYPE_REGEX = Pattern.compile("[1-2]");

    public AddBookAction() {
        super("Adding book...", "Add book");
    }

    @Override
    public void executeCustomAction() {
        BookType bookType;

        if(this.prompt("Enter book type: \n1) Papper\n2) Electronic\n", String.class,
                p -> BOOK_TYPE_REGEX.matcher(p).matches()).equals("1")){
            bookType = BookType.PAPER;
        } else {
            bookType = BookType.ELECTRONIC;
        }

        new BookDaoImpl().createBook(new Book(this.prompt("Enter book name", String.class),
                this.prompt("Enter book name", String.class), bookType));
    }
}
