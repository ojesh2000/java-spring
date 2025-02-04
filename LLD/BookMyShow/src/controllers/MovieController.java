package controllers;

import models.City;
import models.Movie;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    public MovieController(){
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public List<Movie> getMoviesByCity(City city){
        return cityVsMovies.get(city);
    }

    public void addMovie(Movie movie, City city){
        if(cityVsMovies.containsKey(city)){
            cityVsMovies.get(city).add(movie);
        }else{
            cityVsMovies.put(city, new ArrayList<>());
            cityVsMovies.get(city).add(movie);
        }
        allMovies.add(movie);
    }

    public Movie getMovieByName(String name){
        for(Movie movie: allMovies){
            if(movie.getMovieName().equals(name)){
                return movie;
            }
        }
        return null;
    }

    public Map<City, List<Movie>> getCityVsMovies() {
        return cityVsMovies;
    }

    public void setCityVsMovies(Map<City, List<Movie>> cityVsMovies) {
        this.cityVsMovies = cityVsMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }
}
