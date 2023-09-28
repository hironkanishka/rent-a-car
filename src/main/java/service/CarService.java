package service;

import dto.CarDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CarService extends SuperService{
    boolean saveCar(CarDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCar(CarDto dto ,String id) throws SQLException, ClassNotFoundException;
    boolean deleteCar(String id) throws SQLException, ClassNotFoundException;
    CarDto  getCar(String id) throws SQLException, ClassNotFoundException;
    ArrayList<CarDto> getAll() throws SQLException, ClassNotFoundException;
    ArrayList<CarDto> getAllById(String id) throws SQLException, ClassNotFoundException;
}
