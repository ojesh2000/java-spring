import controllers.MovieController;
import controllers.TheatreController;
import models.*;

import java.util.*;


public class Main {
    static MovieController movieController = new MovieController();
    static TheatreController theatreController = new TheatreController();


    public static void main(String[] args) {
        initialize();

        //user1
        createBooking(City.BANGLORE, "Bahubali");
        //user2
        createBooking(City.BANGLORE, "Bahubali");

    }

    private static void initialize() {
        createMovies();
        createTheatres();
    }

    public static void createBooking(City userCity, String movieName) {
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see. i want to see Baahubali
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 5;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

    }

    private static void createTheatres() {
        Movie avengers = movieController.getMovieByName("Avengers");
        Movie bahubali = movieController.getMovieByName("Bahubali");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreens(createScreen());
        inoxTheatre.setCity(City.BANGLORE);
        List<Show> inoxShows = new ArrayList<>();
        Show morningShow = createShows(1, inoxTheatre.getScreens().get(0), avengers, 9);
        Show eveningShow = createShows(2, inoxTheatre.getScreens().get(0), bahubali, 20);
        inoxShows.add(morningShow);
        inoxShows.add(eveningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show morningPvrShow = createShows(3, inoxTheatre.getScreens().get(0), avengers, 9);
        Show eveningPvrShow = createShows(4, inoxTheatre.getScreens().get(0), bahubali, 20);
        pvrShows.add(morningPvrShow);
        pvrShows.add(eveningPvrShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.BANGLORE);
        theatreController.addTheatre(pvrTheatre, City.DELHI);

    }

    private static List<Screen> createScreen(){
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    private static List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=0; i<10; i++){
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }
        return seats;
    }

    private static Show createShows(int showId, Screen screen, Movie movie, int showStartTime){
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }

    private static void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("Avengers");
        avengers.setDuration(180);


        Movie bahubali = new Movie();
        bahubali.setMovieId(2);
        bahubali.setMovieName("Bahubali");
        bahubali.setDuration(200);

        movieController.addMovie(avengers, City.BANGLORE);
        movieController.addMovie(avengers, City.DELHI);

        movieController.addMovie(bahubali, City.BANGLORE);
        movieController.addMovie(bahubali, City.DELHI);

    }
}