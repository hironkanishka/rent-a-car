package service;


import dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerService extends SuperService{
    boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDto dto ) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    CustomerDto  getCustomer(String id) throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException;

}
