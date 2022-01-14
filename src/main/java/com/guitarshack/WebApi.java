package com.guitarshack;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WebApi<T> implements Api<T> {
    private final String url;
    private final Class<T> typeClass;

    public WebApi(String url, Class<T> typeClass) {
        this.url = url;
        this.typeClass = typeClass;
    }

    @Override
    public T get(String queryString) {
        HttpRequest request = buildGetRequest(queryString);
        return send(request);
    }

    @Override
    public T post(String body, String authorisation) {
        HttpRequest request = buildPostRequest(body, authorisation);
        return send(request);
    }

    private T send(HttpRequest request) {
        HttpClient client = HttpClient.newHttpClient();
        T deserialised = null;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            deserialised = new Gson().fromJson(response.body(), typeClass);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return deserialised;
    }

    private HttpRequest buildGetRequest(String queryString) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(url + queryString))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    private HttpRequest buildPostRequest(String body, String authorisation) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("Authorization", authorisation)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }
}
