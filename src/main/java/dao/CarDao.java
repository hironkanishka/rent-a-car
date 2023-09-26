package dao;

import dao.CrudDao;
import entity.CarEntity;

import java.sql.SQLException;

public interface CarDao extends CrudDao<CarEntity,String> {
    boolean updateTable(CarEntity ce,String id) throws SQLException, ClassNotFoundException;
}
