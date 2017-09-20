package by.bsuir.library.util;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailUtil {
    private static final Logger LOGGER = Logger.getLogger(MailUtil.class);

    private static final String SETTINGS = "/settings.properties";
    private Properties props;
    private Session session;

    private MailUtil() throws Exception{
        props = new Properties();

        try {
            props.load(MailUtil.class.getResourceAsStream(SETTINGS));
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }

        final String username = props.getProperty("mail.smtp.username");
        final String password = props.getProperty("mail.smtp.pass");

        session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public void sendRegisterMail(String addressTo, String name, String registerCode){
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(props.getProperty("mail.smtp.username")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(addressTo));
            message.setSubject(props.getProperty("email.register.subject"));
            message.setText(props.getProperty("email.register.greeting") +
                    name + ",\n" + props.getProperty("email.register.message") + registerCode);

            Transport.send(message);

            System.out.println("Done. Check your inbox!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static MailUtil getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final MailUtil INSTANCE;
        static {
            try {
                INSTANCE = new MailUtil();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
