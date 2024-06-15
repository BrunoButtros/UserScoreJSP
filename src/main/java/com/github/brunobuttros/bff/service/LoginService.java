package com.github.brunobuttros.bff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private RestTemplate restTemplate;

    public String authenticate(String username, String password) {
        String authUrl = "http://localhost:8080/auth/login";
        Map<String, String> credentials = new HashMap<>();
        credentials.put("login", username);
        credentials.put("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(credentials, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(authUrl, HttpMethod.POST, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new HttpClientErrorException(response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Authentication failed: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            throw new RuntimeException("An error occurred: " + e.getMessage());
        }
    }
}
