package by.bsuir.library.cache;

import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Cache implements AutoCloseable {
    private static final Logger LOGGER = Logger.getLogger(Cache.class);
    private Properties pro;

    private List<Book> books;
    private List<User> users;

    private Cache() throws Exception{
        try {
            pro = new Properties();
            pro.load(new FileReader("src\\main\\resources\\path.properties"));
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }

        readBooks();
        readUsers();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    private void readBooks(){
        List<Book> books = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(pro.getProperty("bookPath"));
            ObjectInputStream oin = new ObjectInputStream(fis);
            books = (List<Book>) oin.readObject();
        }catch(IOException | ClassNotFoundException | ClassCastException e){
            LOGGER.error(e.getMessage());
        }

        this.books = books;
    }

    private void writeBooks(){
        try {
            FileOutputStream fos = new FileOutputStream(pro.getProperty("bookPath"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            oos.close();
        } catch(IOException e){
            LOGGER.error(e.getMessage());
        }
    }

    private void readUsers(){
        List<User> users = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(pro.getProperty("userPath"));
            ObjectInputStream oin = new ObjectInputStream(fis);
            users = (List<User>) oin.readObject();
        }catch(IOException | ClassNotFoundException e){
            LOGGER.error(e.getMessage());
        }

        this.users = users;
    }

    private void writeUsers(){
        try {
            FileOutputStream fos = new FileOutputStream(pro.getProperty("userPath"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
            oos.close();
        } catch(IOException e){
            LOGGER.error(e.getMessage());
        }
    }

    public static Cache getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void close() throws Exception {
        writeBooks();
        writeUsers();
    }

    private static class SingletonHolder{
        private static final Cache INSTANCE;
        static {
            try {
                INSTANCE = new Cache();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
