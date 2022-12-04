package com.books;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookInitializer implements ApplicationRunner {

    private final BookRepository bookRepository;
    private final RatingService ratingService;

    @Override
    public void run(ApplicationArguments args) {
        Book sapiens = create("Sapiens", "Noah Harari");
        Book kaplaninSirtinda = create("Kaplanin Sirtinda", "Zulfu Livaneli");
        Book mother = create("The Mother", "Maksim Gorki");
        Book kayipTanrilarUlkesi = create("Kayip Tanrilar Ulkesi", "Ahmet Umit");
        List<Book> books = bookRepository.saveAll(List.of(sapiens, kaplaninSirtinda, mother, kayipTanrilarUlkesi));
        log.info("Books: {}", books);
    }

    private Book create(String bookName, String author) {
        Double avgRating = ratingService.getAverageRating(bookName);
        return Book.builder()
                .name(bookName)
                .author(author)
                .avgRating(avgRating)
                .build();
    }
}
