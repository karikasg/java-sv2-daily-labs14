package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    List<Movie> movies = new ArrayList<>();

    public boolean addMovie(Movie movie) {
        return movies.add(movie);
    }

    public List<Movie> moviesByActor(String actor) {
        List<Movie> result = new ArrayList<>();
        return movies.stream().filter(o -> o.getActors().contains(actor)).collect(Collectors.toList());
    }

    public int movieByMaxLength() {
//        return movies.stream().max(Comparator.comparing(o-> o.getLength())).get().getLength();
        return movies.stream().mapToInt(Movie::getLength).max().orElseThrow(() -> new IllegalStateException("Üres lista"));
    }
}
