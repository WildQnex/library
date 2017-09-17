package by.bsuir.library.dao.iml;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.dao.BookDao;
import by.bsuir.library.entity.Book;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookDaoIml implements BookDao {

    private static final Logger LOGGER = Logger.getLogger(BookDaoIml.class);

    @Override
    public List<Book> getAll() {
        return Cache.getInstance().getBooks();
    }

    @Override
    public void createBook(Book book) {
        Cache.getInstance().getBooks().add(book);
    }
}
