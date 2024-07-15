package com.example.Gutendex.client;

import com.example.Gutendex.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GutendexClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public GutendexClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public Book searchBookByTitle(String title) throws Exception {
        String url = "https://gutendex.com/books/?search=" + title;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = objectMapper.readTree(response.body());
        JsonNode bookNode = jsonNode.get("results").get(0);

        Book book = new Book();
        book.setTitle(bookNode.get("title").asText());
        book.setLanguage(bookNode.get("languages").get(0).asText());
        book.setDownloadCount(bookNode.get("download_count").asInt());

        JsonNode authorNode = bookNode.get("authors").get(0);
        book.setAuthorName(authorNode.get("name").asText());
        book.setAuthorBirthYear(authorNode.get("birth_year").asInt());
        book.setAuthorDeathYear(authorNode.get("death_year").asInt());

        return book;
    }
}
