package com.guitarshack;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(exchange -> {
            String s = "Hello World";
            exchange.sendResponseHeaders(200, s.getBytes().length);
            OutputStream response = exchange.getResponseBody();
            response.write(s.getBytes());
            response.close();
        });
        server.start();
    }
}
