package by.bsuir.library.dao.iml;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.dao.BookDao;
import by.bsuir.library.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Book> getBookByAuthor(String author) {
        List<Book> books = Cache.getInstance().getBooks();

        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookByName(String name) {
        List<Book> books = Cache.getInstance().getBooks();

        return books.stream()
                .filter(book -> book.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookByAuthorAndName(String author, String name) {
        List<Book> books = Cache.getInstance().getBooks();

        return books.stream()
                .filter(book -> book.getName().equals(name) && book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookById(long id) {
        List<Book> books = Cache.getInstance().getBooks();
        Optional<Book> optionalBook = books.stream()
                .filter(book -> (book.getId() == id))
                .findAny();
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else{
            return new Book(0L);
        }
    }
}
