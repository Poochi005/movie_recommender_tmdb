package com.movie.movie_recommender.service;

import com.movie.movie_recommender.model.Movie;
import com.movie.movie_recommender.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenre(String genre) {

        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : getAllMovies()) {

            if (movie.getGenres() != null &&
                movie.getGenres().toLowerCase().contains(genre.toLowerCase())) {

                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }

    public Movie searchMovieByTitle(String title) {

        for (Movie movie : getAllMovies()) {

            if (movie.getTitle() != null &&
                movie.getTitle().equalsIgnoreCase(title)) {

                return movie;
            }
        }

        return null;
    }
    public List<Movie> searchMoviesByTitle(String title) {
    return movieRepository.findByTitleContainingIgnoreCase(title);
}
}