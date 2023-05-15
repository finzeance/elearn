package com.mccserverapp.project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.dto.request.EmailRequest;
import com.mccserverapp.project.Service.EmailService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private EmailService emailService;

    @PostMapping("/simple")
    public EmailRequest sendSimpleMessage(@RequestBody EmailRequest emailRequest) {
        return emailService.sendSimpleMessage(emailRequest);
    }

    @PostMapping("/attach")
    public EmailRequest sendMessageWithAttachment(@RequestBody EmailRequest emailRequest) {
        return emailService.sendMessageWithAttachment(emailRequest);
    }

}
