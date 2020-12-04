package ru.sapteh.dao;

import ru.sapteh.model.WareHouse;

import java.util.List;

public interface WareHouseDao {
    String SQL_FIND_ALl = String.format("select * from %s", WareHouse.TABLE_NAME);
    String SQL_FIND_ID = String.format("select * from %s = ?", WareHouse.ID_COLUMN);
    String SQL_INSERT = String.format("insert into %s ( %s ) values (?)", WareHouse.TABLE_NAME, WareHouse.ADDRESS_COLUMN);
    String SQL_UPDATE = String.format("update %s set %s = ? where %s = ?", WareHouse.TABLE_NAME, WareHouse.ADDRESS_COLUMN, WareHouse.ID_COLUMN);
    String SQL_DELETE = String.format("delete from %s where %s = ?", WareHouse.TABLE_NAME, WareHouse.ID_COLUMN);

    List<WareHouse> findAll();
    WareHouse findById(Long id);
    void insert (WareHouse wareHouse);
    void update (WareHouse wareHouse);
    void delete (WareHouse wareHouse);
}
