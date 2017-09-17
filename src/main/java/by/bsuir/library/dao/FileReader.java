package by.bsuir.library.dao;

import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class);
    private static final String USER_PATH = "source\\Users.txt";
    private static final String BOOK_PATH = "source\\Books.txt";

    public static ArrayList<User> readAllUsers(){
        ArrayList<User> users = (ArrayList<User>) read(USER_PATH);
        return users;
    }

    public static ArrayList<Book> readAllBooks(){
        ArrayList<Book> books = (ArrayList<Book>) read(BOOK_PATH);
        return books;
    }

    private static Object read(String path){
        Object books = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            books = oin.readObject();
        }catch(IOException | ClassNotFoundException e){
            LOGGER.error(e.getMessage());
        }
        return books;
    }

    public static void rewriteUsers(ArrayList<User> users){
        rewrite(users, USER_PATH);
    }

    public static void rewriteBooks(ArrayList<Book> books){
        rewrite(books, BOOK_PATH);
    }

    private static void rewrite(Object data, String path){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.flush();
            oos.close();
        } catch(IOException e){
            LOGGER.error(e.getMessage());
        }
    }
}
