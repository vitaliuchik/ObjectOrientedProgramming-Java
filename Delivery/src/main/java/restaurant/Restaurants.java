package restaurant;

import java.util.ArrayList;
import java.util.Collections;

public class Restaurants {
    private ArrayList<Restaurant> restaurants;

    public Restaurants() {
        this.restaurants = new ArrayList<Restaurant>();
    }

    public void addRestaurants(Restaurant ... newRestaurants) {
        Collections.addAll(restaurants, newRestaurants);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
