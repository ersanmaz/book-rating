package com.books;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(value = "author-service", url = "http://author-service:9091/authors")
public interface AuthorService {

    @GetMapping
    Optional<String> getAuthorsByFullName(@RequestParam String fullName);

    @PostMapping
    String saveAuthor(@RequestParam String fullName);
}
