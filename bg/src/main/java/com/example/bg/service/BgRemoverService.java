package com.example.bg.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class BgRemoverService {

    // ✅ 1️⃣ Inject API key
    @Value("${bg.remover.api.key}")
    private String apiKey;

    public byte[] removeBackground(byte[] imageBytes) {

        String url = "https://api.remove.bg/v1.0/removebg";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("image_file", new ByteArrayResource(imageBytes) {
            @Override
            public String getFilename() {
                return "image.png";
            }
        });

        body.add("size", "auto");

        HttpEntity<MultiValueMap<String, Object>> request =
                new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<byte[]> response =
                restTemplate.postForEntity(url, request, byte[].class);

        return response.getBody();
    }
}
