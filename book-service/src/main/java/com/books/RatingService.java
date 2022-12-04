package com.books;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rating-service", url = "http://rating-service:9092/ratings")
public interface RatingService {

    @GetMapping
    Double getAverageRating(@RequestParam String bookName);

    @PostMapping
    void saveRating(@RequestParam String bookName, @RequestParam Double rating);
}
