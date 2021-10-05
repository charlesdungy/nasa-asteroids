package com.nasa_asteroids.project;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

public class CreateRequest {
    
    private final HttpResponse<String> response;

    public CreateRequest(String uri) {
        this.response = generateResponse(uri);
    }

    public String getResponse() {
        return response.body();
    }

    private HttpResponse<String> generateResponse(String uri) {
        HttpResponse<String> localResponse = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build();
            
        try {
            localResponse = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return localResponse;
    }
}