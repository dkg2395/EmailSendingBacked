package com.lti.controller;

import com.lti.model.EmailRequest;
import com.lti.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;
    @GetMapping("/email")
    public String welcome(){
        return "email api";
    }

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
       boolean result= this.emailService.sendMail(emailRequest.getSubject(),emailRequest.getMessage(),emailRequest.getTo());
       // System.out.println(emailRequest);
        if(result){
            return ResponseEntity.ok("Done...");
        }else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent...");
        }



    }
}
