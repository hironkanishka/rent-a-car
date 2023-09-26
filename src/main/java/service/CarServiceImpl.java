package service;

import dao.CarDao;
import dao.DaoFactory;
import dto.CarDto;

import entity.CarEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public class CarServiceImpl implements CarService{
    CarDao cd=(CarDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CAR);
    @Override
    public boolean saveCar(CarDto dto) throws SQLException, ClassNotFoundException {
      return  cd.save(new CarEntity(
                dto.getCarId(),dto.getBrand(),dto.getModel(),dto.getYear(),dto.getVehicleNo() ,dto.getPricePerDay(),dto.getCCategoryId()
        ));

    }

    @Override
    public boolean updateCar(CarDto dto,String id) throws SQLException, ClassNotFoundException {
        return  cd.updateTable(new CarEntity(
                dto.getCarId(),dto.getBrand(),dto.getModel(),dto.getYear(),dto.getVehicleNo() ,dto.getPricePerDay(),dto.getCCategoryId()
        ),id);
    }

    @Override
    public boolean deleteCar(String id) throws SQLException, ClassNotFoundException {
        return cd.delete(id);
    }

    @Override
    public CarDto getCar(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CarDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CarEntity> carEntities= cd.getAll();
        ArrayList<CarDto> cdtos =new ArrayList<>();
        for(CarEntity ce : carEntities )
        {
            CarDto dto =new CarDto(ce.getCarId(),ce.getBrand(),ce.getModel(),ce.getYear(),ce.getVehicleNo(),ce.getPricePerDay(),ce.getCCategoryId());
            cdtos.add(dto);
        } return cdtos;

    }
}
