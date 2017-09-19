package by.bsuir.library.view.item;

import by.bsuir.library.dao.UserDao;
import by.bsuir.library.dao.impl.UserDaoImpl;
import by.bsuir.library.entity.Role;
import by.bsuir.library.entity.User;
import io.bretty.console.view.ActionView;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Random;
import java.util.regex.Pattern;

public class RegisterAction extends ActionView {
    private static final Pattern NAME_REGEX = Pattern.compile("[a-zA-Z]{2,32}");
    private static final Pattern EMAIL_REGEX = Pattern.compile("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$");
    private static final Pattern PASSWORD_REGEX = Pattern.compile("[a-zA-Z0-9]{4,32}");

    private UserDao userDao = new UserDaoImpl();

    public RegisterAction() {
        super("Signing Up", "Sign Up");
    }

    @Override
    public void executeCustomAction() {
        String name = this.prompt("Enter Your name (from 2 to 32 latin symbols): ", String.class,
                n -> NAME_REGEX.matcher(n).matches());
        String mail = this.prompt("Enter Your mail: ", String.class,
                m -> EMAIL_REGEX.matcher(m).matches() && !userDao.isEmailExists(m));
        String password = this.prompt("Enter password (from 4 to 32 latin symbols or digits): ", String.class,
                p -> PASSWORD_REGEX.matcher(p).matches());
        this.prompt("Repeat password: ", String.class, password::equals);

        User newUser = new User(name, mail, BCrypt.hashpw(password, BCrypt.gensalt()), Role.USER,new Random().nextInt(900000) + 100000);
        userDao.createUser(newUser);

        this.println("User successfully registered. Please Sign In using your credentials to continue.");
    }
}
