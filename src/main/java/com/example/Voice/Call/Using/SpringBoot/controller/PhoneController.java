package com.example.Voice.Call.Using.SpringBoot.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    public static final String ACCOUNT_SID = "AC263ec218becd92c09282c051fb9d7c79";
    public static final String AUTH_TOKEN = "f54345a69c63340ee3e8d87c9e4279ce";
    public static final String FROM_NUMBER = "+19163892470";
    public static final String TO_NUMBER = "+918519013280";

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

}
