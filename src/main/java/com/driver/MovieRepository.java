// MovieRepository.java
package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private final Map<String, Movie> movieMap = new HashMap<>();
    private final Map<String, Director> directorMap = new HashMap<>();
    private final Map<String, List<String>> directorMovieMapping = new HashMap<>();

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
        return directorMovieMapping.getOrDefault(director, Collections.emptyList());
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
