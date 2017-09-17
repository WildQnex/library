package by.bsuir.library.dao;

import by.bsuir.library.entity.Book;
import java.util.ArrayList;

public interface BookDao {
    ArrayList<Book> readBooks();
    void rewriteBooks(ArrayList<Book> books);
}
