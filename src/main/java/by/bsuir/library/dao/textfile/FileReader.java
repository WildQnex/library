package by.bsuir.library.dao.textfile;

import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileReader {
    private static final String USER_PATH = "source\\Users.txt";

    public static void writeAllUsersw(ArrayList<User> users){
        try {
            FileOutputStream fos = new FileOutputStream(USER_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
            oos.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<User> readAllUsers(){
        ArrayList<User> users = new ArrayList<User>();

        return users;
    }

    public static ArrayList<Book> readAllBooks(){
        ArrayList<Book> books = new ArrayList<Book>();

        return books;
    }
}
