package net.javaguides.ems.service;

import net.javaguides.ems.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(details.getRecipient());
            simpleMailMessage.setText(details.getMsgBody());
            simpleMailMessage.setSubject(details.getSubject());
            javaMailSender.send(simpleMailMessage);
            return "Mail Sent Successfully";
        } catch (Exception e) {
            logger.info("Error while Sending Mail" + e.getMessage());
            return "Error while Sending Mail";
        }
    }

}
