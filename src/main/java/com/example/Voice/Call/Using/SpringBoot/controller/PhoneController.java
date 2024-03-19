package com.example.Voice.Call.Using.SpringBoot.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    public static final String ACCOUNT_SID = "***";
    public static final String AUTH_TOKEN = "***";
    public static final String FROM_NUMBER = "***";
    public static final String TO_NUMBER = "***";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @GetMapping("/voiceCall")
    public String makeVoiceCall() throws URISyntaxException {
        Call call = Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();

        System.out.println(call.getSid());
        return "Please check your phone";
    }

    @GetMapping("/messageSMS")
    public String makeMSMSmessage() throws URISyntaxException {
        Message message = Message.creator(new PhoneNumber("+15558675309"), new PhoneNumber("+15017250604"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
        return "Please check your phone for message";
    }
}
