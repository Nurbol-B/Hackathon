package com.jdbc.aviatickets.service;

import com.jdbc.aviatickets.entity.Users;
import org.springframework.mail.MailException;


import java.util.Properties;

public interface MailService {
    public void sendEmailForRegistration(Users users) throws MailException;
    Integer generateFourDigitNumber();
    public void flightBooking(String to,String subject,String text);
    public  void deleteBooking(String to,String subject,String text);
}
