package models;

import java.util.*;

public class Show {
    int showId;
    Screen screen;
    Movie movie;
    int showStartTime;
    List<Integer> bookedSeatIds = new ArrayList<>();

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }
}
