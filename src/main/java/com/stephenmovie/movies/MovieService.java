package com.stephenmovie.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is where all the business logic goes in.
 */
@Service
public class MovieService {
    /**
     * AutoWired will automatically create an instance.
     */
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> movieList() {
        try {
            return movieRepository.findAll();
        }catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public Optional<Movie> getMovie(String imdbId) {
        try{
            return movieRepository.findByImdbId(imdbId);
        }catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
