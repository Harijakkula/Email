package org.example;
import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws MessagingException, IOException {
        List<File> attachments = new ArrayList<>();
        File file1 = new File("/home/harikrishna/Pictures/Screenshot from 2023-02-21 17-01-15.png");
        attachments.add(file1);
        File file2 = new File("/home/harikrishna/Pictures/Screenshot from 2023-02-22 14-53-23.png");
        attachments.add(file2);
        File file3 = new File("/home/harikrishna/Pictures/Screenshot from 2023-02-22 14-53-29.png");
        attachments.add(file3);

        CFMailOptions options = new CFMailOptions();
        options.setTo("jakkulaharikrishna413@gmail.com");
        options.setFrom("jakkulaharikrishna1@gmail.com");
        options.setSubject("Testing Mail For Attachments");
        options.setcc("jakkulaharikrishna413@gmail.com");
        options.setbcc(null);
        options.setUsername("jakkulaharikrishna1@gmail.com");
        options.setPassword("fftzvmvdlsfgtjvg");
        options.setAttachmentFiles(attachments);
        options.sethost("smtp.gmail.com");
        options.setport(465);
        options.setDebug(true);
        options.setUseSSL(true);
        options.setUseTLS(true);
        CFMail.sendEmail(options,"Hi, This is Testing mail ");
    }
}

