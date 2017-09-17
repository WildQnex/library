package by.bsuir.library.dao.iml;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.dao.BookDao;
import by.bsuir.library.entity.Book;

import java.util.List;

public class BookDaoIml implements BookDao {

    @Override
    public List<Book> getAll() {
        return Cache.getInstance().getBooks();
    }

    @Override
    public void createBook(Book book) {
        Cache.getInstance().getBooks().add(book);
    }

    @Override
    public long getLastId() {
        List<Book> books = Cache.getInstance().getBooks();

        return books.stream()
                .max((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .orElse(new Book(0L))
                .getId();
    }
}
