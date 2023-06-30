package com.stephenmovie.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://stephenmovieapp.vercel.app")
@RestController
@RequestMapping("/api/v1")
public class MovieController {
    /**
     * AutoWired will automatically create an instance.
     */
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
       try{
           return new ResponseEntity<List<Movie>>(movieService.movieList(), HttpStatus.OK);
       } catch (Exception ex) {
           throw new Error("Cannot get movies");
       }
    }

    @GetMapping("/movie/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        try{
            return new ResponseEntity<Optional<Movie>>(movieService.getMovie(imdbId), HttpStatus.OK);
        }catch (Exception ex) {
            throw new Error("Cannot get Movie");
        }
    }
}
