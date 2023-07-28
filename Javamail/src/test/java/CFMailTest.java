import org.example.CFMail;
import org.example.CFMailOptions;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;

class CFMailTest {

    @Test
    void sendEmailWithValidOptionsAndMailText() throws MessagingException, IOException {
        CFMailOptions options = new CFMailOptions();
        options.setTo("harikrishna@natsoft.us");
        options.setFrom("jakkulaharikrishna1@gmail.com");
        options.setSubject("Testing Mail For Attachments");
        options.setcc("jakkulaharikrishna413@gmail.com");
        options.setbcc(null);
        options.setUsername("jakkulaharikrishna1@gmail.com");
        options.setPassword("fftzvmvdlsfgtjvg");
        options.sethost("smtp.gmail.com");
        options.setport(465);
        options.setDebug(true);
        options.setUseSSL(true);
        options.setUseTLS(true);
        String mailText = "This is a test email message.";
        CFMail.sendEmail(options, mailText);
        System.out.println("EMail sent succesfully");
        // Verify that the email was sent successfully
        // You can do this by checking the logs or by using a third-party tool to check the inbox of the recipient
    }

    @Test
    void sendEmailWithoutUsernameAndPassword() throws MessagingException, IOException {

        CFMailOptions options = new CFMailOptions();
        options.setTo("harikrishna@natsoft.us");
        options.setFrom("jakkulaharikrishna1@gmail.com");
        options.setSubject("Testing Mail For Attachments");
        options.setcc("jakkulaharikrishna413@gmail.com");
        options.setbcc(null);
        options.setUsername(null);
        options.setPassword(null);
        options.sethost("smtp.gmail.com");
        options.setport(465);
        options.setDebug(true);
        options.setUseSSL(true);
        options.setUseTLS(true);
        String mailText = "This is a test email message.";
        CFMail.sendEmail(options, mailText);
        System.err.println("username and password requried for sequire mail");
        // Verify that the error message "Username and password required for secure mail sending" is printed to the console
    }

    @Test
    void sendEmailWithoutToOrFromOrSubject() throws MessagingException, IOException {
        CFMailOptions options = new CFMailOptions();
        options.setTo(null);
        options.setFrom(null);
        options.setSubject(null);
        options.setcc(null);
        options.setbcc(null);
        options.setUsername("jakkulaharikrishna1@gmail.com");
        options.setPassword("fftzvmvdlsfgtjvg");
        options.sethost("smtp.gmail.com");
        options.setport(465);
        options.setDebug(true);
        options.setUseSSL(true);
        options.setUseTLS(true);

        String mailText = "This is a test email message.";
        CFMail.sendEmail(options, mailText);
        System.err.println("nothing to be sent");
        // Verify that the error message "Nothing to be sent. Missing (to/from/subject)" is printed to the console
    }

}
