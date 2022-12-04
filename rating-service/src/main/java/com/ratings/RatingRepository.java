package com.ratings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("select avg(r.rating) from Rating r where r.bookName = :bookName")
    Double getAverageRating(@Param("bookName") String bookName);
}
