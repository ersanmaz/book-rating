package com.books;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final RatingService ratingService;

    @GetMapping("/{bookName}")
    public Optional<Book> getByBookName(@PathVariable String bookName) {
        return bookRepository.findByName(bookName);
    }

    @PostMapping("/{bookName}")
    public Book save(@PathVariable String bookName, @RequestParam String author) {
        String savedAuthor = authorService.saveAuthor(author);
        Book book = Book.builder().name(bookName).author(savedAuthor).build();
        return bookRepository.save(book);
    }

    @PostMapping("/rating/{bookName}")
    public void saveRating(@PathVariable String bookName, @RequestParam Double rating) {
        bookRepository.findByName(bookName).ifPresentOrElse(book -> updateRating(bookName, rating, book), () -> {
            throw new IllegalArgumentException(String.format("There is no such a book with name %s", bookName));
        });
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    private void updateRating(String bookName, Double rating, Book book) {
        ratingService.saveRating(bookName, rating);
        Double avgRating = ratingService.getAverageRating(bookName);
        log.info("Old Avg Rating: {}, New Avg Rating: {}", book.getAvgRating(), avgRating);
        book.setAvgRating(avgRating);
        Book savedBook = bookRepository.save(book);
        log.info("Saved Book: {}", savedBook);
    }
}
