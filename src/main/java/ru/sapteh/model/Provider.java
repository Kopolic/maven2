package ru.sapteh.model;

import java.util.HashSet;
import java.util.Set;

public class Provider {
    private Long id;
    private String name;
    private Set<Item> items = new HashSet<Item>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Item> getItems() {
        return items;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    @Override
    public String toString(){
        return String.format("provider[id= %d, name= %s]", getId(), getName());
    }
}
