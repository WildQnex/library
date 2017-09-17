package by.bsuir.library.logic;

import by.bsuir.library.entity.Book;

import java.util.ArrayList;

public class BookFinder {
    public static Book findBookById(int id){
        Book book = new Book(1, "Java. Methods of Programming", "Blinov");
        return book;
    }

    public static ArrayList<Book> findBooksByName(String name){
        ArrayList<Book> books = new ArrayList<>();
        return books;
    }

    public static ArrayList<Book> findBooksByAuthor(String author){
        ArrayList<Book> books = new ArrayList<>();
        return books;
    }

}
