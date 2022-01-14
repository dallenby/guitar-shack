package com.guitarshack;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        QueryParser queryParser = new QueryParser();

        ReorderCheckerBuilder reorderCheckerBuilder = new ReorderCheckerBuilder();

        ReorderChecker reorderChecker = reorderCheckerBuilder.build();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(exchange -> {
            String query = exchange.getRequestURI().getQuery();

            Map<String, String> parameters = queryParser.parse(query);

            Integer productId = Integer.parseInt(parameters.get("productId"));
            Integer quantity = Integer.parseInt(parameters.get("quantity"));
            String s;
            try{
                reorderChecker.onSale(productId, quantity);
                s = "200: OK";
            } catch (Exception e){
                s = "500: ERROR " + e.getMessage();
                e.printStackTrace();
            }

            exchange.sendResponseHeaders(200, s.getBytes().length);
            OutputStream response = exchange.getResponseBody();
            response.write(s.getBytes());
            response.close();
        });
        server.start();


    }
}
