package restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

    private ArrayList<Item> menu = new ArrayList<Item>();

    public Menu() {}

    public Menu(Item ... food) {
        Collections.addAll(menu, food);
    }

    public void addItem(Item ... food) {
        Collections.addAll(menu, food);
    }

    public void removeItem(Item ... food) {
        for (Item item: food) {
            menu.remove(item);
        }
    }

    public ArrayList<Item> getMenu() {
        return (ArrayList<Item>) List.copyOf(menu);
    }

    public String displayMenu(Item ... food) {
        StringBuilder result = new StringBuilder();
        for (Item item: food) {
            result.append(item.getItemName()).append(": ").append(item.getItemPrice()).append("\n");
        }
        return result.toString();
    }

}
