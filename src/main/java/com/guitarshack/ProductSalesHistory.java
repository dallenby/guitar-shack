package com.guitarshack;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductSalesHistory implements SalesHistory {


    @Override
    public int total(int productId, LocalDate startDate, LocalDate endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(String.format("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales?productId=%s&startDate=%s&endDate=%s&action=%s",
                        productId,
                        startDate.format(formatter),
                        endDate.format(formatter), "total")))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            SalesTotal salesTotal = new Gson().fromJson(response.body(), SalesTotal.class);
            return salesTotal.getTotal();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    return -1;
    }
}
