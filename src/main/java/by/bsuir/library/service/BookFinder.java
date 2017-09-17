package by.bsuir.library.service;

import by.bsuir.library.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFinder {
    public static Book findBookById(int id){
        Book book = new Book(1, "Java. Methods of Programming", "Blinov");
        return book;
    }

    public static List<Book> findBooksByName(String name){
        ArrayList<Book> books = new ArrayList<>();
        return books;
    }

    public static List<Book> findBooksByAuthor(String author){
        ArrayList<Book> books = new ArrayList<>();
        return books;
    }

    public static List<Book> findBookByAuthorAndName(String author, String name){
        ArrayList<Book> books = new ArrayList<>();
        return books;
    }
}
