package com.stephenmovie.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "https://stephenmovieapp.vercel.app")
@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    /**
     * AutoWired will automatically create an instance.
     */
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        try{
            return new ResponseEntity<>(reviewService.createReview(payload.get("reviewMessage"), payload.get("imdbId")),
                    HttpStatus.CREATED);
        }catch (Exception ex){
            throw new Error("Could not create review");
        }
    }
}
