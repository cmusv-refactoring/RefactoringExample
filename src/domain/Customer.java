package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The customer class represents the customer of the store. Like the other classes it has data and accessors.
 */
public class Customer {
    protected String name = "no name yet";
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        String result = "Rental Record for " + name + "\n";

        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = rentals.next();

            //determine amounts for each line
            switch (each.getTape().getMovie().priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.daysRented() > 2)
                        thisAmount += (each.daysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.daysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.daysRented() > 3)
                        thisAmount += (each.daysRented() - 3) * 1.5;
                    break;

            }
            totalAmount += thisAmount;

            // add frequent renter points
            frequentRenterPoints ++;

            // add bonus for a two-day new release rental
            if ((each.getTape().getMovie().priceCode() == Movie.NEW_RELEASE) && each.daysRented() > 1) frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.getTape().getMovie().getName()+ "\t" + thisAmount + "\n";

        }
        //add footer lines
        result +=  "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;

    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public static Customer get(String name) {
        return Record.getCustomer(name);
    }

    public void persist() {
        Record.addCustomer(this.name, this);
    }

    public String getName() {
        return name;
    }
}
