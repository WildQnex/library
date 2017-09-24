package by.bsuir.library.view.item;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.BookDaoImpl;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.BookType;
import by.bsuir.library.entity.User;
import by.bsuir.library.util.MailUtil;
import io.bretty.console.view.ActionView;

import java.util.regex.Pattern;

public class AddBookAction extends ActionView{

    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    private static final Pattern BOOK_TYPE_REGEX = Pattern.compile("Electronic|Paper", Pattern.CASE_INSENSITIVE);

    public AddBookAction() {
        super("Adding book...", "Add book");
    }

    @Override
    public void executeCustomAction() {
        String bookName = this.prompt("Enter book name: ", String.class);
        String bookAuthor = this.prompt("Enter book author: ", String.class);

        BookType bookType = BookType.valueOf(this.prompt("Enter book type: (Paper or Electronic)\n", String.class,
                p -> BOOK_TYPE_REGEX.matcher(p).matches()).toUpperCase());

        Book book = new Book(bookName, bookAuthor, bookType);
        bookDao.createBook(book);

        userDao.getAll().stream()
                .filter(User::isActvated)
                .forEach(u -> MailUtil.getInstance().sendBookAddingMail(u.getMail(), u.getName(), book));
    }
}
