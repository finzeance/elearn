package com.mccserverapp.project.Service;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mccserverapp.project.Model.dto.request.EmailRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailRequest sendSimpleMessage(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        javaMailSender.send(message);
        System.out.println();
        System.out.println("Email success to send...");
        return emailRequest;

    }

    public EmailRequest sendMessageWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach()));

            helper.addAttachment(file.getFilename(), file);
            javaMailSender.send(message);
            System.out.println();
            System.out.println("Email success to send...");
        } catch (Exception e) {
            System.out.println("Email failed to send...");
        }

        return emailRequest;
    }

    // Cara 1 = Multiple by Email
    public EmailRequest sendMessageWithAttachmentMultiple(EmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(InternetAddress.parse(emailRequest.getTo()));
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach()));

            helper.addAttachment(file.getFilename(), file);
            javaMailSender.send(message);
            System.out.println();
            System.out.println("Email success to end...");
        } catch (Exception e) {
            throw new IllegalStateException("Email failed to send...");
        }

        return emailRequest;
    }

    // Cara 2 - Multiple by Object
    public Iterable<EmailRequest> sendMessageWithAttachmentMultipleObject(
            Iterable<EmailRequest> emailRequests) {
        emailRequests.forEach(emailRequest -> {
            try {
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(emailRequest.getTo());
                helper.setSubject(emailRequest.getSubject());
                helper.setText(emailRequest.getBody());

                FileSystemResource file = new FileSystemResource(
                        new File(emailRequest.getAttach()));

                helper.addAttachment(file.getFilename(), file);
                javaMailSender.send(message);
                System.out.println();
                System.out.println("Email success to send...");
            } catch (Exception e) {
                throw new IllegalStateException("Email failed to send...");
            }
        });
        return emailRequests;
    }

}
