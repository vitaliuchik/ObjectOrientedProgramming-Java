package order;

import restaurant.Item;

public class Selected {
    private int amount;
    private Item item;

    public Selected(Item item ,int amount) {
        this.amount = amount;
        this.item = item;
    }

    public int getPrice() {
        return amount * item.getItemPrice();
    }
}
