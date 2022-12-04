package com.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public Optional<String> getAuthorsByFullName(@RequestParam String fullName) {
        return authorService.getAuthorsByFullName(fullName);
    }

    @PostMapping
    public String saveAuthor(@RequestParam String fullName) {
        return authorService.saveAuthor(fullName);
    }
}
