package com.guitarshack;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class SmsMessageBuilder {
    private final String message;
    private final String destination;
    private final String sender;

    public SmsMessageBuilder(String message, String destination, String sender) {
        this.message = message;
        this.destination = destination;
        this.sender = sender;
    }

    public Map<String, String> generateBody() {
        Map<String, String> body = new HashMap<>();
        body.put("content", message);
        body.put("destination", destination);
        body.put("sender", sender);
        return body;
    }

    public String generateBodyAsString() {
        return new Gson().toJson(generateBody());
    }
}
