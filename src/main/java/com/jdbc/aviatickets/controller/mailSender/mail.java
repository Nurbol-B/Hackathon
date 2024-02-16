package com.jdbc.aviatickets.controller.mailSender;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mail {
    public static void main(String[] args) {
        String from = "derg6626@gmail.com";
        String to = "nurbolbakasov1@gmail.com";
        String host = "smtp.gmail.com";
        String smtpPort = "465";

        Properties properties = new Properties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",smtpPort);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");




        Session session = Session.getInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,"udcv bciq didr pjob\n");
                    }
                }

                );
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from ));
            message.addRecipients(Message.RecipientType.TO,to);
            message.setSubject("AviaTickets");
            message.setText("Вы успешно забронировали рейс");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
