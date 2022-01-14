package com.guitarshack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmsMessageBuilderTest {
    private final SmsMessageBuilder messageBuilder = new SmsMessageBuilder("test", "07582335830", "Daniel");

    @Test
    public void addsMessageToBody() {
        assertEquals("test", messageBuilder.generateBody().get("content"));
    }

    @Test
    public void addsDestinationToBody() {
        assertEquals("07582335830", messageBuilder.generateBody().get("destination"));
    }

    @Test
    public void addsSenderToBody() {
        assertEquals("Daniel", messageBuilder.generateBody().get("sender"));
    }

}