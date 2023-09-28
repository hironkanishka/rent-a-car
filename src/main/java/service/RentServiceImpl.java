package service;

import dao.DaoFactory;
import dao.RentDao;
import dto.CustomerDto;
import dto.RentDto;
import entity.CustomerEntity;
import entity.RentEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class RentServiceImpl implements RentService {
    RentDao rd=(RentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.RENT);
    @Override
    public boolean saveRent(RentDto d) throws SQLException, ClassNotFoundException {
        return rd.save(new RentEntity(
                d.getRentID(),d.getFromDate(),d.getToDate(),d.getPerDayRent(),
                d.getAdvancedPayment(),d.getRefundable(),d.getTotal(),d.getBalance(),d.getCCustId(),d.getCCarId(),d.getIsReturned()
        ));
    }

    @Override
    public boolean updateRent(RentDto dto, String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteRent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RentDto getRent(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RentDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<RentEntity> rEntities= rd.getAll();
        ArrayList<RentDto> rdtos =new ArrayList<>();
        for(RentEntity r : rEntities )
        {
            RentDto dto =new RentDto(
                    r.getRentID(),r.getFromDate(),r.getToDate(),r.getPerDayRent(),r.getAdvancedPayment(),r.getRefundable(),r.getTotal(),r.getBalance(),r.getCCustId(),r.getCCarId(),r.getIsReturned()
            );
            rdtos.add(dto);
        } return rdtos;
    }

    @Override
    public ArrayList<RentDto> getAllAvailable(String s) throws Exception {
        ArrayList<RentEntity> rEntities= rd.getAllAvailable(s);
        ArrayList<RentDto> rdtos =new ArrayList<>();
        for(RentEntity r : rEntities )
        {
            RentDto dto =new RentDto(
                    r.getRentID(),r.getFromDate(),r.getToDate(),r.getPerDayRent(),r.getAdvancedPayment(),r.getRefundable(),r.getTotal(),r.getBalance(),r.getCCustId(),r.getCCarId(),r.getIsReturned()
            );
            rdtos.add(dto);
        } return rdtos;
    }
}
