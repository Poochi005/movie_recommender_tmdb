package com.movie.movie_recommender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tmdb_movies")
public class Movie {

    @Id
    private Long id;

    private String title;

    private String overview;

    private Double popularity;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "vote_count")
    private Integer voteCount;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(columnDefinition = "TEXT")
    private String genres;

    @Column(name = "poster_path")
private String posterPath;

    // Default constructor
    public Movie() {
    }


    // Parameterized constructor
    public Movie(Long id, String title, String overview,
                 Double popularity, Double voteAverage,
                 Integer voteCount, String releaseDate,
                 String genres) {

        this.id = id;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.releaseDate = releaseDate;
        this.genres = genres;
    }


    // Get ID
    public Long getId() {
        return id;
    }

    // Set ID
    public void setId(Long id) {
        this.id = id;
    }


    // Get title
    public String getTitle() {
        return title;
    }

    // Set title
    public void setTitle(String title) {
        this.title = title;
    }


    // Get overview
    public String getOverview() {
        return overview;
    }

    // Set overview
    public void setOverview(String overview) {
        this.overview = overview;
    }


    // Get popularity
    public Double getPopularity() {
        return popularity;
    }

    // Set popularity
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }


    // Get rating
    public Double getVoteAverage() {
        return voteAverage;
    }

    // Set rating
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }


    // Get vote count
    public Integer getVoteCount() {
        return voteCount;
    }

    // Set vote count
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }


    // Get release date
    public String getReleaseDate() {
        return releaseDate;
    }

    // Set release date
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    // Get genres
    public String getGenres() {
        return genres;
    }

    // Set genres
    public void setGenres(String genres) {
        this.genres = genres;
    }
    public String getPosterPath() {
    return posterPath;
}

public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
}


    // Convert TMDB genre JSON into genre names
    public List<String> getGenresList() {

        List<String> genreNames = new ArrayList<>();

        if (genres == null || genres.isEmpty()) {
            return genreNames;
        }

        String[] parts = genres.split("\"name\"\\s*:\\s*\"");

        for (int i = 1; i < parts.length; i++) {

            String genre = parts[i].split("\"")[0];

            genreNames.add(genre);
        }

        return genreNames;
    }
}