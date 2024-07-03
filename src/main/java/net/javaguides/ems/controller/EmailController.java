package net.javaguides.ems.controller;

import net.javaguides.ems.entity.EmailDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.ems.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;


    // Sending a simple Email
    @PostMapping("/sendMail")
    public ResponseEntity<String>
    sendMail(@RequestBody EmailDetails details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return ResponseEntity.ok(status);
    }
}
