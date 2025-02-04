package controllers;

import models.City;
import models.Movie;
import models.Show;
import models.Theatre;

import java.util.*;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatres;
    List<Theatre> allTheatres;

    public TheatreController(){
        cityVsTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public Map<City, List<Theatre>> getCityVsTheatres() {
        return cityVsTheatres;
    }

    public void setCityVsTheatres(Map<City, List<Theatre>> cityVsTheatres) {
        this.cityVsTheatres = cityVsTheatres;
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public void setAllTheatres(List<Theatre> allTheatres) {
        this.allTheatres = allTheatres;
    }

    public void addTheatre(Theatre theatre, City city) {
        if(!cityVsTheatres.containsKey(city)){
            cityVsTheatres.put(city, new ArrayList<>());
        }
        cityVsTheatres.get(city).add(theatre);
        allTheatres.add(theatre);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie interestedMovie, City userCity) {
        List<Theatre> theatres = cityVsTheatres.get(userCity);
        Map<Theatre, List<Show>> showsTheatreWise = new HashMap<>();
        for(Theatre theatre: theatres){
            for(Show show: theatre.getShows()){
                if(interestedMovie.getMovieName().equals(show.getMovie().getMovieName())){
                    if(!showsTheatreWise.containsKey(theatre)){
                        showsTheatreWise.put(theatre, new ArrayList<>());
                    }
                    showsTheatreWise.get(theatre).add(show);
                }
            }
        }
        return showsTheatreWise;
    }
}
