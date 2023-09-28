package dao;

import dao.util.CrudUtil;
import dto.RentDto;
import entity.CustomerEntity;
import entity.RentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDaoImpl implements RentDao{
    @Override
    public boolean save(RentEntity r) throws SQLException, ClassNotFoundException {
        String sql="Insert into rent VALUES (?,?,?,?,?,?,?,?,?,?,?)";

   return CrudUtil.executeUpdate(sql,
           r.getRentID(), r.getFromDate(),r.getToDate(),r.getPerDayRent(),r.getAdvancedPayment(),r.getRefundable(),r.getTotal(),r.getBalance(),r.getCCustId(),r.getCCarId(),r.getIsReturned()
   ) ;
    }

    @Override
    public boolean update(RentEntity rentEntity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RentEntity get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RentEntity> getAll() throws SQLException, ClassNotFoundException {
        String sql="select * from rent";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<RentEntity> rEntities =new ArrayList<>();
        while (rst.next()){
            RentEntity re=new RentEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getDouble(4),rst.getDouble(5),
                    rst.getDouble(6),rst.getDouble(7),
                    rst.getDouble(8),rst.getString(9),rst.getString(10),rst.getString(11)
            );
            rEntities.add(re);
        } return rEntities;
    }

    @Override
    public ArrayList<RentEntity> getAllAvailable(String s) throws Exception {
        String sql="select * from rent where (Is_returned = ?)";
        ResultSet rst = CrudUtil.executeQuery(sql,s);
        ArrayList<RentEntity> rEntities =new ArrayList<>();
        while (rst.next()){
            RentEntity re=new RentEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getDouble(4),rst.getDouble(5),
                    rst.getDouble(6),rst.getDouble(7),
                    rst.getDouble(8),rst.getString(9),rst.getString(10),rst.getString(11)
            );
            rEntities.add(re);
        } return rEntities;
    }
}
