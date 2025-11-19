package com.example.movierecommender;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private List<Movie> movieDb = new ArrayList<>();

    public MovieController() {
        // We call the Data Seeder method to load our "Database"
        loadMovieData();
    }

    @GetMapping("/recommend/{genre}")
    public List<Movie> recommendMovies(@PathVariable String genre) {
        return movieDb.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieDb;
    }

    // --- THE DATA SEEDER ---
    // This mimics loading data from a real database
    private void loadMovieData() {
        // THRILLER (Your Favorite)
        movieDb.add(new Movie("Se7en", "Thriller"));
        movieDb.add(new Movie("Silence of the Lambs", "Thriller"));
        movieDb.add(new Movie("Shutter Island", "Thriller"));
        movieDb.add(new Movie("Gone Girl", "Thriller"));
        movieDb.add(new Movie("Zodiac", "Thriller"));
        movieDb.add(new Movie("Prisoners", "Thriller"));
        movieDb.add(new Movie("Nightcrawler", "Thriller"));
        movieDb.add(new Movie("Joker", "Thriller"));
        movieDb.add(new Movie("Black Swan", "Thriller"));
        movieDb.add(new Movie("Fight Club", "Thriller"));
        movieDb.add(new Movie("Parasite", "Thriller"));
        movieDb.add(new Movie("Get Out", "Thriller"));

        // ACTION
        movieDb.add(new Movie("The Dark Knight", "Action"));
        movieDb.add(new Movie("Inception", "Action"));
        movieDb.add(new Movie("Avengers: Endgame", "Action"));
        movieDb.add(new Movie("Gladiator", "Action"));
        movieDb.add(new Movie("John Wick", "Action"));
        movieDb.add(new Movie("Mad Max: Fury Road", "Action"));
        movieDb.add(new Movie("Top Gun: Maverick", "Action"));
        movieDb.add(new Movie("Mission Impossible: Fallout", "Action"));
        movieDb.add(new Movie("Black Panther", "Action"));
        movieDb.add(new Movie("Spider-Man: No Way Home", "Action"));

        // SCI-FI
        movieDb.add(new Movie("Interstellar", "Sci-Fi"));
        movieDb.add(new Movie("The Matrix", "Sci-Fi"));
        movieDb.add(new Movie("Dune", "Sci-Fi"));
        movieDb.add(new Movie("Blade Runner 2049", "Sci-Fi"));
        movieDb.add(new Movie("Arrival", "Sci-Fi"));
        movieDb.add(new Movie("The Martian", "Sci-Fi"));
        movieDb.add(new Movie("Avatar", "Sci-Fi"));
        movieDb.add(new Movie("Ex Machina", "Sci-Fi"));
        movieDb.add(new Movie("Star Wars: A New Hope", "Sci-Fi"));

        // HORROR
        movieDb.add(new Movie("The Conjuring", "Horror"));
        movieDb.add(new Movie("It", "Horror"));
        movieDb.add(new Movie("Hereditary", "Horror"));
        movieDb.add(new Movie("A Quiet Place", "Horror"));
        movieDb.add(new Movie("Sinister", "Horror"));
        movieDb.add(new Movie("The Shining", "Horror"));
        movieDb.add(new Movie("Us", "Horror"));

        // COMEDY
        movieDb.add(new Movie("The Hangover", "Comedy"));
        movieDb.add(new Movie("Superbad", "Comedy"));
        movieDb.add(new Movie("Deadpool", "Comedy"));
        movieDb.add(new Movie("Step Brothers", "Comedy"));
        movieDb.add(new Movie("21 Jump Street", "Comedy"));
        movieDb.add(new Movie("Dumb and Dumber", "Comedy"));

        // DRAMA
        movieDb.add(new Movie("The Shawshank Redemption", "Drama"));
        movieDb.add(new Movie("The Godfather", "Drama"));
        movieDb.add(new Movie("Forrest Gump", "Drama"));
        movieDb.add(new Movie("Schindler's List", "Drama"));
        movieDb.add(new Movie("Good Will Hunting", "Drama"));

        // ANIMATION
        movieDb.add(new Movie("Spider-Man: Into the Spider-Verse", "Animation"));
        movieDb.add(new Movie("Toy Story", "Animation"));
        movieDb.add(new Movie("The Lion King", "Animation"));
        movieDb.add(new Movie("Coco", "Animation"));
        movieDb.add(new Movie("Up", "Animation"));
        movieDb.add(new Movie("Inside Out", "Animation"));
    }
}

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
}