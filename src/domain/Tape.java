package domain;

/**
 * The tape class represents a physical tape to store a movie and its respective serial number.
 */
public class Tape {
    private String serialNumber;
    private Movie movie;

    public Tape(String serialNumber, Movie movie) {
        this.serialNumber = serialNumber;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
