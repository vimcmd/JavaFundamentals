package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch15_servlets.sub04_multithreadingAndEmail.action;

import com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch15_servlets.sub04_multithreadingAndEmail.creator.SessionCreator;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* # 10 # thread which sending emails */

public class MailThread extends Thread {
    private MimeMessage message;
    private final String to;
    private final String subject;
    private final String body;
    private final Properties properties;

    public MailThread(String to, String subject, String body, Properties properties) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.properties = properties;
    }

    private void init() {
        // mail session object
        // look lib at http://www.oracle.com/technetwork/java/javamail/index.html
        // or use build manager
        Session mailSession = ( new SessionCreator(properties) ).createSession();
        mailSession.setDebug(true);

        // create email message object
        message = new MimeMessage(mailSession);
        try {
            // load parameters to email message object
            message.setSubject(subject);
            message.setContent(body, "text/html");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        } catch (AddressException e) {
            System.err.println("Wrong address: " + to + " " + e);
            // in log file
        } catch (MessagingException e) {
            System.err.println("Message formation error: " + e);
            // in log file
        }
    }

    public void run() {
        init();
        try {
            // send email message
            Transport.send(message);
        } catch (MessagingException e) {
            System.err.println("Error occurred while sending message " + e);
            // log in file
        }
    }
}
