package ru.sapteh.model;

import java.util.HashSet;
import java.util.Set;

public class Item {
    public static final String TABLE_NAME = "items";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String WAREHOUSE_ID_COLUMN = "warehouse_id";

    private Long id;
    private String name;
    private Long warehouse_id;
    private Set<Provider> providers = new HashSet<Provider>();

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Long getWarehouse_id() {
        return warehouse_id;
    }
    public Set<Provider> getProviders() {
        return providers;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWareHouse_id(Long wareHouse_id) {
        this.warehouse_id = wareHouse_id;
    }
    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }
    @Override
    public String toString(){
        return String.format("item[id= %d , name= %s]", getId(), getName());
    }
}
