package com.example.assignment.service;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class NewsService {

    private final String API_KEY = "750d264fc6d64deaab42f2b25f217e8c"; // Replace with your News API key
    private final String NEWS_API_URL = "https://newsapi.org/v2/top-headlines";

    public Map<String, Object> fetchTopHeadlines(String country) {
        String url = UriComponentsBuilder.fromHttpUrl(NEWS_API_URL)
                .queryParam("country", country)
                .queryParam("apiKey", API_KEY)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Map.class);
    }
}
