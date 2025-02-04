package model;

import java.util.*;

public class Inventory {
    List<Item> items;

    public Inventory() {

    }

    public Item getItem(int codeNumber) {
        return this.items.stream()
                .filter(item -> item.getCodeNumber() == codeNumber)
                .findFirst()
                .orElse(null);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item, int codeNumber) {
        if (items == null) {
            setItems(new ArrayList<>());
        }
        this.items.add(item);
    }
}
