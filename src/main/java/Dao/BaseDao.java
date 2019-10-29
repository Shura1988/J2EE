package Dao;


import java.io.IOException;
import java.sql.SQLException;


public interface BaseDao {

    void add() throws SQLException, IOException;

    void show() throws SQLException;

    void enter() throws SQLException, IOException;


}
