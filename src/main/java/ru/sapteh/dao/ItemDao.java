package ru.sapteh.dao;

import ru.sapteh.model.Item;

import java.util.List;

public interface ItemDao {
    String SQL_FIND_ALL = String.format("select * from %s", Item.TABLE_NAME);
    String SQL_FIND_ID = String.format("select * from %s = ?", Item.ID_COLUMN);
    String SQL_INSERT = String.format("insert into %s ( %s, %s ) values (?, ?)", Item.TABLE_NAME, Item.NAME_COLUMN, Item.WAREHOUSE_ID_COLUMN);
    String SQL_UPDATE = String.format("update %s set %s = ? where %s = ?", Item.TABLE_NAME, Item.NAME_COLUMN, Item.ID_COLUMN);
    String SQL_DELETE = String.format("delete from %s where %s = ?", Item.TABLE_NAME, Item.ID_COLUMN);

    List<Item> findAll();
    Item findById(Long id);
    void insert (Item item);
    void update (Item item);
    void delete (Item item);
}
