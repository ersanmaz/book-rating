package com.ratings;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RatingInitializer implements ApplicationRunner {

    private final RatingRepository ratingRepository;

    @Override
    public void run(ApplicationArguments args) {
        Rating sapiens1 = Rating.builder().rating(5.0).bookName("Sapiens").build();
        Rating sapiens2 = Rating.builder().rating(4.0).bookName("Sapiens").build();
        Rating kaplaninSirtinda1 = Rating.builder().rating(4.0).bookName("Kaplanin Sirtinda").build();
        Rating kaplaninSirtinda2 = Rating.builder().rating(4.0).bookName("Kaplanin Sirtinda").build();
        Rating kaplaninSirtinda3 = Rating.builder().rating(5.0).bookName("Kaplanin Sirtinda").build();
        Rating mother1 = Rating.builder().rating(5.0).bookName("The Mother").build();
        Rating mother2 = Rating.builder().rating(5.0).bookName("The Mother").build();
        Rating mother3 = Rating.builder().rating(4.0).bookName("The Mother").build();
        Rating kayipTanrilarUlkesi1 = Rating.builder().rating(5.0).bookName("Kayip Tanrilar Ulkesi").build();
        Rating kayipTanrilarUlkesi2 = Rating.builder().rating(4.0).bookName("Kayip Tanrilar Ulkesi").build();

        ratingRepository.saveAll(List.of(sapiens1, sapiens2, kaplaninSirtinda1, kaplaninSirtinda2, kaplaninSirtinda3, mother1, mother2, mother3, kayipTanrilarUlkesi1, kayipTanrilarUlkesi2));
    }
}
