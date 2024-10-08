package com.example.assignment.controller;




import com.example.assignment.service.NewsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/api/news")
    public Map<String, Object> getNews(@RequestParam(defaultValue = "us") String country) {
        return newsService.fetchTopHeadlines(country);
    }
}
