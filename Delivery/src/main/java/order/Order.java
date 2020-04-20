package order;

import restaurant.Item;
import restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Restaurant restaurant;
    private ArrayList<Selected> items;
    private Status status;

    private enum Status {
        InProcess,
        Cancelled;
    }

    public Order(String id, Restaurant rest, ArrayList<Selected> items) {
        this.id = id;
        restaurant = rest;
        status = Status.InProcess;
        this.items = (ArrayList<Selected>) List.copyOf(items);
    }

    public String trackOrder() {
        return status.toString();
    }



    public int getPrice() {
        int result = 0;
        for (Selected item: items) {
            result += item.getPrice();
        }
        return result;
    }

    public void CancelOrder() {
        status = Status.Cancelled;
    }


}
