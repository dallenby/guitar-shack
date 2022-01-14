package com.guitarshack;

import org.junit.Test;

import static org.junit.Assert.*;

public class WebApiTest {

    @Test
    public void post() {
        String authorisation = System.getenv("AUTHORISATION");
        String phoneNumber = System.getenv("PHONE_NUMBER");
        SmsMessageBuilder messageBuilder = new SmsMessageBuilder("message", phoneNumber, "test");
        WebApi<SmsResponse> webApi = new WebApi<>("https://api.thesmsworks.co.uk/v1/message/send", SmsResponse.class);
        assertEquals("SENT", webApi.post(messageBuilder.generateBodyAsString(), authorisation).status);
    }
}