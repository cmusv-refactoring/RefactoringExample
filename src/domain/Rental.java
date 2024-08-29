package domain;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {
    private Tape tape;
    private int daysRented;

    public Rental(Tape tape, int daysRented) {
        this.tape = tape;
        this.daysRented = daysRented;
    }

    public int daysRented() {
        return daysRented;
    }

    public Tape getTape() {
        return tape;
    }
}
