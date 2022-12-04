package com.ratings;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingRepository ratingRepository;

    @GetMapping
    public Double getAverageRating(@RequestParam String bookName) {
        return ratingRepository.getAverageRating(bookName);
    }

    @PostMapping
    public void saveRating(@RequestParam String bookName, @RequestParam Double rating) {
        ratingRepository.save(Rating.builder().bookName(bookName).rating(rating).build());
    }
}
