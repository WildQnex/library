package by.bsuir.library.cache;

import by.bsuir.library.entity.Book;
import by.bsuir.library.entity.User;
import by.bsuir.library.cache.exception.CacheException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Cache implements AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(Cache.class);
    private static final String SETTINGS = "/settings.properties";

    private Properties properties;
    private String dirPath;
    private String fileBookPath;
    private String fileUserPath;

    private List<Book> books;
    private List<User> users;

    private Cache() throws CacheException {
        try {
            properties = new Properties();
            properties.load(Cache.class.getResourceAsStream(SETTINGS));

            this.dirPath = properties.getProperty("directoryPath");
            this.fileBookPath = properties.getProperty("directoryPath") + File.separator + properties.getProperty("bookPath");
            this.fileUserPath = properties.getProperty("directoryPath") + File.separator + properties.getProperty("userPath");
        } catch (IOException e){
            throw new CacheException("Error. Unable to open " + SETTINGS);
        }
        createFilesIfNotExist();
        readBooks();
        readUsers();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    private void readBooks() throws CacheException {
        List<Book> books = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileBookPath);
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            books = (List<Book>) oin.readObject();
        } catch (EOFException e){
            LOGGER.error("Error. Incorrect books input stream, file was cleared");
        } catch (IOException | ClassNotFoundException e){
            throw new CacheException("Error. Unable to open file");
        }

        this.books = books;
    }

    private void writeBooks() throws CacheException {
        try (FileOutputStream fos = new FileOutputStream(fileBookPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(books);
            oos.flush();
        } catch (IOException e){
            throw new CacheException("Error. Impossible to write books to file");
        }
    }

    private void readUsers() throws CacheException {
        List<User> users = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileUserPath);
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            users = (List<User>) oin.readObject();
        } catch (EOFException e){
            LOGGER.error("Error. Incorrect users input stream, file was cleared");
        } catch (IOException | ClassNotFoundException e){
            throw new CacheException("Error. Unable to open file");
        }

        this.users = users;
    }

    private void writeUsers() throws CacheException {
        try (FileOutputStream fos = new FileOutputStream(fileUserPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.users);
            oos.flush();
        } catch (IOException e){
            throw new CacheException("Error. Impossible to write books to file");
        }
    }

    private void createFilesIfNotExist() throws CacheException{
        try {
            File directoryPath = new File(dirPath);
            directoryPath.mkdir();

            File bookFile = new File(fileBookPath);
            bookFile.createNewFile();
            File userFile = new File(fileUserPath);
            userFile.createNewFile();
        } catch (IOException e) {
            throw new CacheException("Error. Unable to create " + fileBookPath + " or " + fileUserPath);
        }
    }

    public static Cache getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void close() throws CacheException {
        createFilesIfNotExist();
        writeBooks();
        writeUsers();
    }

    private static class SingletonHolder {
        private static final Cache INSTANCE;
        static {
            try {
                INSTANCE = new Cache();
            } catch (CacheException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
