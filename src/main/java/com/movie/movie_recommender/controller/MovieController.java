package com.movie.movie_recommender.controller;

import com.movie.movie_recommender.model.Movie;
import com.movie.movie_recommender.service.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Movie> movies = movieService.getAllMovies();

        model.addAttribute("movies", movies);

        return "movies";
    }
  @GetMapping("/movies")
public String getMovies(
        @RequestParam(required = false) String title,
        Model model) {

    List<Movie> movies;

    if (title != null && !title.trim().isEmpty()) {
        movies = movieService.searchMoviesByTitle(title);
    } else {
        movies = movieService.getAllMovies();
    }

    model.addAttribute("movies", movies);
    model.addAttribute("searchTitle", title);

    return "movies";
}  
}