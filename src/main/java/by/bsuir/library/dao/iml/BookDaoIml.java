package by.bsuir.library.dao.iml;

import by.bsuir.library.dao.BookDao;
import by.bsuir.library.entity.Book;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class BookDaoIml implements BookDao {

    private static final Logger LOGGER = Logger.getLogger(BookDaoIml.class);
    private Properties pro;

    public BookDaoIml() {
        try {
            pro = new Properties();
            pro.load(new FileReader("src/main/resources/path.properties"));
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public ArrayList<Book> readBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(pro.getProperty("bookPath"));
            ObjectInputStream oin = new ObjectInputStream(fis);
            books = (ArrayList<Book>) oin.readObject();
        }catch(IOException | ClassNotFoundException e){
            LOGGER.error(e.getMessage());
        }
        return books;
    }

    @Override
    public  void rewriteBooks(ArrayList<Book> books){
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

}
