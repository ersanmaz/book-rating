package com.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorInitializer implements ApplicationRunner {

    private final AuthorRepository authorRepository;

    @Override
    public void run(ApplicationArguments args) {
        Author maksim = Author.builder().firstName("Maksim").lastName("Gorki").build();
        Author zulfu = Author.builder().firstName("Zulfu").lastName("Livaneli").build();
        Author noah = Author.builder().firstName("Noah").lastName("Harari").build();
        Author ahmet = Author.builder().firstName("Ahmet").lastName("Umit").build();
        authorRepository.saveAll(List.of(maksim, zulfu, noah, ahmet));
    }
}
