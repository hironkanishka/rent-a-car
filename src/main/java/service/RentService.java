package service;

import dto.RentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentService extends SuperService{
    boolean saveRent(RentDto dto) throws SQLException, ClassNotFoundException;
    boolean updateRent(RentDto dto ,String id) throws SQLException, ClassNotFoundException;
    boolean deleteRent(String id) throws SQLException, ClassNotFoundException;
    RentDto  getRent(String id) throws SQLException, ClassNotFoundException;
    ArrayList<RentDto> getAll() throws SQLException, ClassNotFoundException;
    ArrayList<RentDto> getAllAvailable(String s) throws Exception;
}
