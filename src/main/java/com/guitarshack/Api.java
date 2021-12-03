package com.guitarshack;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Api<T> {
    private final String url;
    private final Class<T> typeClass;

    public Api(String url, Class<T> typeClass) {
        this.url = url;
        this.typeClass = typeClass;
    }

    public T get(String queryString) {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url + queryString))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        T returnObject = null;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            returnObject = new Gson().fromJson(response.body(), typeClass);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return returnObject;
    }
}
