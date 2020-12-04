package ru.sapteh.model;

import java.util.HashSet;
import java.util.Set;

public class WareHouse {
    public static final String TABLE_NAME = "warehouse";
    public static final String ID_COLUMN = "id";
    public static final String ADDRESS_COLUMN = "address";

    private Long id;
    private String address;
    private Set<Item> items = new HashSet<Item>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Set<Item> getItems() {
        return items;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    @Override
    public String toString(){
        return String.format("warehouse[id= %d, address= %s]", getId(), getAddress());
    }
}
