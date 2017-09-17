package by.bsuir.library.dao;

import by.bsuir.library.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();
    void createBook(Book book);
}
