package com.stephenmovie.movies;

/**
 * This class communicates with the database
 */

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    /**
     * @param imdbId
     * @return Movie with the unique imdbId
     * @description This a dynamic query added because MongoRespository does not
     * have a query like this. But the framework is smart enough to identify the
     * defined property, all you need to do is make sure the property is unique.
     */
    Optional<Movie> findByImdbId(String imdbId);
}
