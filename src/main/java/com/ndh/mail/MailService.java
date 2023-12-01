package com.ndh.mail;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class MailService implements IMail {

    private final String email = "nguyendangha2405@gmail.com";
    private final String password = "ukzjeunykrkphocr";


    @Override
    public void sendEmailToGetPassword(String to, String title, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };

        Session session = Session.getInstance(properties, authenticator);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(email);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            message.setSubject(title);
            message.setText(content);

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
