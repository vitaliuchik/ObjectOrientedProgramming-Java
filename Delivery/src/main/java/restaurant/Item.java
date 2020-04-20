package restaurant;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getItemName() {
        return name;
    }

    public int getItemPrice() {
        return price;
    }

}
