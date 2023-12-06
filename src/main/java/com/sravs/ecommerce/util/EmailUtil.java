package com.sravs.ecommerce.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class EmailUtil {
private JavaMailSender sender;
    public void sendMail(String toAddress,String body) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
        mimeMessageHelper.setTo(toAddress);
        mimeMessageHelper.setSubject("Employee details");
        mimeMessageHelper.setText("Please fin your details");
       // mimeMessageHelper.addAttachment("Employee",new File(filePath));
        sender.send(message);
    }
 }



