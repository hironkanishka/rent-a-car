package service;

import dao.CarDao;
import dao.CustomerDao;
import dao.DaoFactory;
import dto.CarDto;
import dto.CustomerDto;
import entity.CarEntity;
import entity.CustomerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService{
    CustomerDao cd=(CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return  cd.save(new CustomerEntity(
                dto.getCustId(),dto.getName(),dto.getNic(),dto.getAddress(),dto.getPhone()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto c) throws SQLException, ClassNotFoundException {
       return cd.update(new CustomerEntity(
               c.getCustId(),c.getName(),c.getNic(),c.getAddress(),c.getPhone()
       ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return cd.delete(id);
    }

    @Override
    public CustomerDto getCustomer(String id) throws SQLException, ClassNotFoundException {

        CustomerEntity ce= cd.get(id);
        return new CustomerDto(
                ce.getCustId(),ce.getName(),ce.getNic(),ce.getAddress(),ce.getPhone() );

    }

    @Override
    public ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerEntity> cEntities= cd.getAll();
        ArrayList<CustomerDto> cdtos =new ArrayList<>();
        for(CustomerEntity ce : cEntities )
        {
            CustomerDto dto =new CustomerDto(ce.getCustId(),ce.getName(),ce.getNic(),ce.getAddress(),ce.getPhone());
            cdtos.add(dto);
        } return cdtos;
    }
}
