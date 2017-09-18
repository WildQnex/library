package by.bsuir.library.dao;

import by.bsuir.library.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAll();
    void createBook(Book book);
    long getLastId();
    List<Book> getBookByAuthor(String author);
    List<Book> getBookByName(String name);
    List<Book> getBookByAuthorAndName(String author, String name);
    Book getBookById(long id);
}
