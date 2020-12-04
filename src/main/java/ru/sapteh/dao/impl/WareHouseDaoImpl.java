package ru.sapteh.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapteh.DataSource;
import ru.sapteh.dao.WareHouseDao;
import ru.sapteh.model.WareHouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class WareHouseDaoImpl implements WareHouseDao {

    @Autowired
    private DataSource dataSource;

    public List<WareHouse> findAll() {
        Connection connection = null;
        List<WareHouse> result = new ArrayList<WareHouse>();
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALl);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                WareHouse wareHouse = new WareHouse();
                wareHouse.setId(rs.getLong("id"));
                wareHouse.setAddress(rs.getString("address"));
                result.add(wareHouse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
        return result;
    }
    public WareHouse findById(Long id) {
        Connection connection = null;
        WareHouse wareHouse = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                wareHouse = new WareHouse();
                wareHouse.setId(resultSet.getLong("id"));
                wareHouse.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dataSource.closeConnection(connection);
        }
        return wareHouse;
    }
    public void insert(WareHouse wareHouse) {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, wareHouse.getAddress());
            int resultSet = statement.executeUpdate();
            ResultSet resultSet1 = statement.getGeneratedKeys();
            if (resultSet == 1){
                wareHouse.setId(resultSet1.getLong(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }
    public void update(WareHouse wareHouse) {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1,wareHouse.getAddress());
            statement.setLong(2,wareHouse.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dataSource.closeConnection(connection);
        }
    }
    public void delete(WareHouse wareHouse) {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1,wareHouse.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dataSource.closeConnection(connection);
        }
    }
}
