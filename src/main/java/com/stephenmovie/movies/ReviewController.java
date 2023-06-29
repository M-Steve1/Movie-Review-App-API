package com.stephenmovie.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/review")
public class ReviewController {
    /**
     * AutoWired will automatically create an instance.
     */
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        try{
            return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewMessage"), payload.get("imdbId")),
                    HttpStatus.CREATED);
        }catch (Exception ex){
            throw new Error("Could not create review");
        }
    }
}
