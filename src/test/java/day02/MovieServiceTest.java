package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    MovieService movieService = new MovieService();

    @BeforeEach
    void init() {

        movieService.addMovie(new Movie("Első", 123, List.of("Béla", "Géza", "András", "Józsi")));
        movieService.addMovie(new Movie("Második", 182, List.of("János", "Géza", "Zsolt", "Józsi")));
        movieService.addMovie(new Movie("Harmadik", 65, List.of("Géza", "András", "Józsi", "Aladár")));
    }

    @Test
    void moviesByActor() {
        assertEquals(1, movieService.moviesByActor("Zsolt").size());
        assertEquals(2, movieService.moviesByActor("András").size());
        assertEquals(3, movieService.moviesByActor("Géza").size());
    }

    @Test
    void movieByMaxLength() {
        assertEquals(182, movieService.movieByMaxLength());
    }
}