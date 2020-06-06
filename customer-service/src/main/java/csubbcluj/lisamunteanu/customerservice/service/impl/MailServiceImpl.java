package csubbcluj.lisamunteanu.customerservice.service.impl;

import csubbcluj.lisamunteanu.customerservice.model.Customer;
import csubbcluj.lisamunteanu.customerservice.service.MailService;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {
    private static final String CUSTOMER = "customer";

    private static final String SENDER_NAME = "senderName";

    private static final String URL = "url";

    private final SpringTemplateEngine springTemplateEngine;

    private final JavaMailSender javaMailSender;

    private final MessageSource messageSource;

    public MailServiceImpl(SpringTemplateEngine springTemplateEngine, JavaMailSender javaMailSender, MessageSource messageSource) {
        this.springTemplateEngine = springTemplateEngine;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
    }

    @Async
    public void sendEmail(String sendTo, String subject, String content) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);

        mimeMessageHelper.setTo(sendTo);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);

        javaMailSender.send(message);

    }

    @Override
    public void sendMessageUsingThymeleafTemplate(
            String to, String subject, Customer customer)
            throws MessagingException {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariable(CUSTOMER, customer);
        thymeleafContext.setVariable(SENDER_NAME, "Echipa TechWorld");
        thymeleafContext.setVariable(URL, "http://localhost:4200/techworld/");
        String htmlBody = springTemplateEngine.process("welcomeEmail.html", thymeleafContext);

        sendEmail(to, subject, htmlBody);
    }
}
