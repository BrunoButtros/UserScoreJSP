package com.github.brunobuttros.bff.service;

import com.github.brunobuttros.bff.dto.UserListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ListaService {

    private final RestTemplate restTemplate;
    private final String userscoreBaseUrl;

    @Autowired
    public ListaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.userscoreBaseUrl = "http://localhost:8080";
    }

    public List<UserListDTO> getAllUserScores() {
        String url = userscoreBaseUrl + "/user/scores";
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserListDTO>>() {}
        ).getBody();
    }
}
