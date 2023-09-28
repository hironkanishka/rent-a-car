package dao;

import dao.util.CrudUtil;

import entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(CustomerEntity ce) throws SQLException, ClassNotFoundException {
        String sql="Insert into customer values(?,?,?,?,?)";
        return  CrudUtil.executeUpdate(sql,ce.getCustId(),ce.getName(),ce.getNic(),ce.getAddress(),ce.getPhone());
    }

    @Override
    public boolean update(CustomerEntity ce) throws SQLException, ClassNotFoundException {
        String sql="Update customer set customerName = ?, nic = ?, address = ?, phone = ? where (customerId = ?)";
        return  CrudUtil.executeUpdate(sql,ce.getName(),ce.getNic(),ce.getAddress(),ce.getPhone(),ce.getCustId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("Delete from customer where customerId=?",s);
    }

    @Override
    public CustomerEntity get(String s) throws SQLException, ClassNotFoundException {
             ResultSet rst = CrudUtil.executeQuery("select * from customer where customerId =?", s);

             while (rst.next()){
                 CustomerEntity   ce =new CustomerEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5)
            ); return ce;
             }

            return null;

    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws SQLException, ClassNotFoundException {
        String sql="select * from customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<CustomerEntity> cEntities =new ArrayList<>();
        while (rst.next()){
            CustomerEntity ce=new CustomerEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5)
            );
            cEntities.add(ce);
        } return cEntities;
    }

    }

