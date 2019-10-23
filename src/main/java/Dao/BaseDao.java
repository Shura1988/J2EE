package Dao;


import java.sql.SQLException;


public interface BaseDao<T> {

    void add(T model) throws SQLException;

    void show(String login, T model) throws SQLException;


}
