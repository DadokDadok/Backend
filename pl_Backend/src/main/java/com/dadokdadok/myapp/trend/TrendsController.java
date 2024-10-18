package com.dadokdadok.myapp.trend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TrendsController {

    private final RestTemplate restTemplate;

    public TrendsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/trends")
    public ResponseEntity<String> getTrends() {
        String url = "https://trends.google.com/trends/api/dailytrends?geo=KR";
        String response = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}

