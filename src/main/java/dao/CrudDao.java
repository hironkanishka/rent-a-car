package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T,ID> extends SuperDao{
     boolean save(T t) throws SQLException, ClassNotFoundException;
     boolean update(T t) throws SQLException, ClassNotFoundException;
     boolean delete(ID id) throws SQLException, ClassNotFoundException;
    T get (ID id) ;
    ArrayList<T > getAll() throws SQLException, ClassNotFoundException;

}
