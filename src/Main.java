import domain.Customer;
import domain.Movie;
import domain.Record;
import domain.Rental;
import domain.Tape;

public class Main {
    public static void main(String[] args) {
        // Create Movies
        Movie movie1 = new Movie("Inception", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Toy Story", Movie.CHILDREN);
        Movie movie3 = new Movie("The Godfather", Movie.REGULAR);

        // Persist Movies in Record
        movie1.persist();
        movie2.persist();
        movie3.persist();

        // Create Tapes
        Tape tape1 = new Tape("SN001", movie1);
        Tape tape2 = new Tape("SN002", movie2);
        Tape tape3 = new Tape("SN003", movie3);

        // Create Rentals
        Rental rental1 = new Rental(tape1, 5); // 5 days rented
        Rental rental2 = new Rental(tape2, 3); // 3 days rented
        Rental rental3 = new Rental(tape3, 7); // 7 days rented

        // Create Customers and add Rentals
        Customer customer1 = new Customer("Alice");
        customer1.addRental(rental1);
        customer1.addRental(rental2);

        Customer customer2 = new Customer("Bob");
        customer2.addRental(rental3);

        // Persist Customers in Record

        Record.addCustomer(customer1.getName(), customer1);
        Record.addCustomer(customer2.getName(), customer2);

        // Print Statements for Customers
        System.out.println(customer1.statement());
        System.out.println(customer2.statement());
    }
}