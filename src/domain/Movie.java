package domain;

/**
 * Movie is just a simple data class.
 */
public class Movie {
    private String name = "no name yet";
    public static final int CHILDREN = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private int priceCode;

    public Movie(String name, int priceCode) {
        this.name = name;
        this.priceCode = priceCode;
    }

    public int priceCode() {
        return priceCode;
    }

    public void persist() {
        Record.addMovie(name, this);
    }

    public  Movie get() {
        return Record.getMovie(name);
    }

    public String getName() {
        return name;
    }
}
