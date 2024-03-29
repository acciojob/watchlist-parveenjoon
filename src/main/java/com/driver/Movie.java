// Movie.java
package com.driver;

public class Movie {

    private String name;
    private int durationInMinutes;
    private double imdbRating;

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
    // Override toString method for better logging or debugging
    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", imdbRating=" + imdbRating +
                '}';
    }
}
