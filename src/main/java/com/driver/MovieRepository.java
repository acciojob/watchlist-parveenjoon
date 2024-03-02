// MovieRepository.java
package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap = new HashMap<>();
    private HashMap<String, Director> directorMap = new HashMap<>();
    private HashMap<String, List<String>> directorMovieMapping = new HashMap<>();

    public void saveMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        directorMovieMapping.computeIfAbsent(director, k -> new ArrayList<>()).add(movie);
    }

    public Movie findMovie(String movie) {
        return movieMap.get(movie);
    }

    public Director findDirector(String director) {
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director) {
        return directorMovieMapping.getOrDefault(director, new ArrayList<>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director) {
        directorMap.remove(director);
        directorMovieMapping.remove(director);
    }

    public void deleteAllDirector() {
        directorMap.clear();
        directorMovieMapping.clear();
    }
}
