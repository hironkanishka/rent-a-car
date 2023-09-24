package service;

import dao.DaoFactory;
import dao.UserDao;
import dto.UserProfileDto;
import entity.UserProfileEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService{
    public boolean saveUser(UserProfileDto udto) throws SQLException, ClassNotFoundException {

        UserDao ud= (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.USER);
        UserProfileEntity ue=new UserProfileEntity(
                udto.getName(),udto.getNic(),udto.getUserName(),udto.getPassword()
        );
        return ud.save(ue);

    }

    @Override
    public boolean updateUser(UserProfileDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public UserProfileDto getUser(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<UserProfileDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
