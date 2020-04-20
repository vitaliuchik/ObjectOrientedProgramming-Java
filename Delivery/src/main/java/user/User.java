package user;

import order.Order;
import order.Selected;
import restaurant.Item;
import restaurant.Restaurant;
import restaurant.Restaurants;

import java.util.ArrayList;

public class User {
    private String id;
    private Restaurants restaurants;
    private Restaurant restaurant;
    private ArrayList<Selected> items;
    private Order order;

    public User(String id, Restaurants restaurants) {
        this.id = id;
        this.restaurants = restaurants;
        items = new ArrayList<Selected>();
    }

    public void seeMenu() {
        System.out.println(restaurant.getMenu().displayMenu());
    }

    public Restaurant searchRest() {
        return new Restaurant();
    }

    public void selectRestaurant(Restaurant rest) {
        restaurant = rest;
    }

    public void addItem(Item item, int amount) {
        for (Item meal : restaurant.getMenu().getMenu()) {
            if (meal.equals(item))
                items.add(new Selected(item, amount));
        }
    }

    public void makeOrder(ArrayList<Selected> items) {
        order = new Order(id, restaurant, items);
        items = new ArrayList<Selected>();
    }

    public void cancelOrder() {
        order.CancelOrder();
    }

}
