package org.example;
import javax.mail.Message;
import javax.mail.Session;
import  javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;
public class CFMail {
    public static void sendEmail(CFMailOptions options, String mailText) throws MessagingException, IOException {
        /*  properties inorder to connect mail server and to set up the properties */
        Properties props = System.getProperties();
        String host = options.gethost();
        int port = options.getport();
        int timeout = options.getTimeout();
        boolean useTLS = options.isUseTLS();
        boolean useSSL = options.isUseSSL();
        boolean debug = options.isDebug();
        props.put("mail.smtp.host", host);/*  SMTP server hostname to the value of the "server" variable.
                                            This tells the JavaMail API which SMTP server to connect to when sending email messages.*/

        props.put("mail.smtp.port", port);/*SMTP server port number to the value of the "port" variable.
                                          The port number is a unique identifier that enables the SMTP server to differentiate between different types of traffic that it receives.*/

        props.put("mail.smtp.timeout", timeout);
        props.put("mail.smtp.starttls.enable", useTLS);
        props.put("mail.smtp.ssl.enable", useSSL);

        if (useSSL == true) {
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        }
        Multipart multipart = new MimeMultipart();
//        // Add the file attachments to the multipart message
//        if (options.getAttachmentFiles() != null) {
//            for (File file : options.getAttachmentFiles()) {
//                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//                attachmentBodyPart.attachFile(file);
//                multipart.addBodyPart(attachmentBodyPart);
//                System.out.println("Added Attachment Suceesfully...");
//            }
//        }
        /*Create a session with the SMTP server using the provided credentials and
        Getting the instance of the session attribute and then the authentication happens next*/
        if ((options.getUsername() != null) && (options.getPassword() != null)) {
                try {
                   Session session = Session.getInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(options.getUsername(), options.getPassword());
                        }
                    });
                    MimeMessage message = new MimeMessage(session);
                    session.setDebug(debug);
                    //which extends the format of email message to support text in character
                    if ((options.getFrom() != null) && (options.getTo() != null) && (options.getSubject() != null)) {
                        message.setFrom(new InternetAddress(options.getFrom()));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(options.getTo()));
                        message.setSubject(options.getSubject());
                        if (options.getcc() != null) {
                            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(options.getcc()));
                            System.out.println("Added CC sucessfully....");
                        }
                        if (options.getbcc() != null) {
                            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(options.getbcc()));
                            System.out.println("Add BCC Successfully....");
                        }
                        message.setSubject(options.getSubject());
                        message.setText(mailText);
                        Transport tr = session.getTransport("smtp");
                        tr.connect(host, port, options.getUsername(), options.getPassword());
                        tr.sendMessage(message, message.getAllRecipients());
                        System.out.println("Email Sent Sucessfully...");
                        tr.close();

                    }else {
                        System.out.println("Nothing to be sent . Missing (to/from/subject)");

                    }
                } catch (MessagingException e) {
                    System.out.println("Error ! Failed to sent .." + e);
                }
            }else {
               System.err.println("Username and password requried for secure mail sendng");
            }
        }
    }


