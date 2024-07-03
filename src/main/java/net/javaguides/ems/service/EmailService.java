package net.javaguides.ems.service;

import net.javaguides.ems.entity.EmailDetails;

public interface EmailService {

    // To send a simple email
    String sendSimpleMail(EmailDetails details);
}
