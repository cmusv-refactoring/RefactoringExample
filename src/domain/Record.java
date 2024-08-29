package domain;

import java.util.HashMap;
import java.util.Map;

public class Record {
    private static Map<String, Movie> movie = new HashMap<>();
    private static Map<String, Customer> customer = new HashMap<>();


    public static void clean() {
        movie = new HashMap<>();
    }

    public static void addMovie(String key, Movie mValue) {
        if (movie.containsKey(key)) {
            movie.replace(key, mValue);
        } else {
            movie.put(key, mValue);
        }


    }

    public static Movie getMovie(String name) {
        return movie.get(name);
    }

    public static void addCustomer(String key, Customer cValue) {
        if (customer.containsKey(key)) {
            customer.replace(key, cValue);
        } else {
            customer.put(key, cValue);
        }


    }

    public static Customer getCustomer(String name) {
        return customer.get(name);
    }
}
