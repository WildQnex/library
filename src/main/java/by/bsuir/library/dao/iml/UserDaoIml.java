package by.bsuir.library.dao.iml;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.entity.User;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class UserDaoIml implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(BookDaoIml.class);
    private Properties pro;

    public UserDaoIml() {
        try {
            pro = new Properties();
            pro.load(new FileInputStream("src\\main\\resources\\path.properties"));
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public ArrayList<User> readUsers(){
        ArrayList<User> books = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(pro.getProperty("userPath"));
            ObjectInputStream oin = new ObjectInputStream(fis);
            books = (ArrayList<User>) oin.readObject();
        }catch(IOException | ClassNotFoundException e){
            LOGGER.error(e.getMessage());
        }
        return books;
    }

    @Override
    public  void rewriteUsers(ArrayList<User> books){
        try {
            FileOutputStream fos = new FileOutputStream(pro.getProperty("userPath"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            oos.close();
        } catch(IOException e){
            LOGGER.error(e.getMessage());
        }
    }

}