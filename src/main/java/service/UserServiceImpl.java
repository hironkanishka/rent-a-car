package service;

import dao.DaoFactory;
import dao.UserDao;
import dto.CarDto;
import dto.UserProfileDto;
import entity.CarEntity;
import entity.UserProfileEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService{
    UserDao ud= (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.USER);
    public boolean saveUser(UserProfileDto udto) throws SQLException, ClassNotFoundException {


        UserProfileEntity ue=new UserProfileEntity(
               udto.getId(), udto.getName(),udto.getNic(),udto.getUserName(),udto.getPassword()
        );
        return ud.save(ue);

    }

    @Override
    public boolean updateUser(UserProfileDto udto) throws SQLException, ClassNotFoundException {
        UserProfileEntity ue=new UserProfileEntity(
                udto.getId(),  udto.getName(),udto.getNic(),udto.getUserName(),udto.getPassword()
        );
        return ud.update(ue);
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
       return ud.delete(id);
    }

    @Override
    public UserProfileDto getUser(String id) throws SQLException, ClassNotFoundException {
        UserProfileEntity e =ud.get(id);
        UserProfileDto dto =new UserProfileDto(e.getId(),e.getName(),e.getNic(),e.getUserName(),e.getTxtPassword());
        return dto;
    }

    @Override
    public ArrayList<UserProfileDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<UserProfileEntity> ue= ud.getAll();
        ArrayList<UserProfileDto> udtos =new ArrayList<>();
        for(UserProfileEntity e : ue )
        {
            UserProfileDto dto =new UserProfileDto(e.getId(),e.getName(),e.getNic(),e.getUserName(),e.getTxtPassword());
            udtos.add(dto);
        } return udtos;
    }
}
