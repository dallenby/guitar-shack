package com.guitarshack;

public class ReorderProduct implements Reorder {
    @Override
    public void alert(String message) {
        String authorisation = System.getenv("AUTHORISATION");
        String phoneNumber = System.getenv("PHONE_NUMBER");
        WebApi<SmsResponse> api = new WebApi<SmsResponse>("https://api.thesmsworks.co.uk/v1/message/send", SmsResponse.class);
        SmsMessageBuilder messageBuilder = new SmsMessageBuilder(message, phoneNumber, "test");
        api.post(messageBuilder.generateBodyAsString(), authorisation);
    }
}
