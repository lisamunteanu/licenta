package csubbcluj.lisamunteanu.customerservice.service;

import csubbcluj.lisamunteanu.customerservice.model.Customer;

import javax.mail.MessagingException;
import java.util.Map;

public interface MailService {
    void sendEmail(String sendTo, String subject, String content) throws MessagingException;

    void sendMessageUsingThymeleafTemplate(
            String to, String subject, Customer customer)
            throws MessagingException;
}
