package dao;

import dao.util.CrudUtil;
import entity.CarEntity;
import entity.CategoryEntity;
import entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDaoImpl implements CarDao{
    @Override
    public boolean save(CarEntity ce) throws SQLException, ClassNotFoundException {
        String sql="Insert into car values(?,?,?,?,?,?,?)";
        return  CrudUtil.executeUpdate(sql,ce.getCarId(),ce.getBrand(),ce.getModel(),ce.getYear(),ce.getVehicleNo(),
                ce.getPricePerDay(),ce.getCCategoryId()
                );

    }

    @Override
    public boolean update(CarEntity carEntity) throws SQLException, ClassNotFoundException {
        return false;
    }


    public boolean updateTable(CarEntity ce,String id) throws SQLException, ClassNotFoundException {
        String sql="UPDATE car SET carId = ? , brand = ?, model = ?, year = ?, vehicle_number = ?, price_per_day = ?, category_categoryId = ? WHERE (carId = ?)";
        return  CrudUtil.executeUpdate(sql,ce.getCarId(),ce.getBrand(),ce.getModel(),ce.getYear(),ce.getVehicleNo(),
                ce.getPricePerDay(),ce.getCCategoryId(),id
        );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql="Delete from car where carId= ? ";
        return  CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public CarEntity get(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from car where carId =?", s);

        while (rst.next()){
            CarEntity ce =new CarEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5),
                    rst.getDouble(6),rst.getString(7)
            ); return ce;
        }

        return null;
    }

    @Override
    public ArrayList<CarEntity> getAll() throws SQLException, ClassNotFoundException {
        String sql="select * from car";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<CarEntity> carEntities =new ArrayList<>();
        while (rst.next()){
            CarEntity ce =new CarEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),
                    rst.getString(5),Double.valueOf(rst.getString(6)),rst.getString(7)
                    );
            carEntities.add(ce);
        } return carEntities;
    }

    @Override
    public ArrayList<CarEntity> getAllbyID(String id) throws SQLException, ClassNotFoundException {
        String sql="select * from car where category_categoryId=?";
        ResultSet rst = CrudUtil.executeQuery(sql , id);
        ArrayList<CarEntity> carEntities =new ArrayList<>();
        while (rst.next()){
            CarEntity ce =new CarEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),
                    rst.getString(5),Double.valueOf(rst.getString(6)),rst.getString(7)
            );
            carEntities.add(ce);
        } return carEntities;
    }
}
