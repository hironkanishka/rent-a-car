package dao;


import dao.util.CrudUtil;
import entity.UserProfileEntity;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {


    @Override
    public boolean save(UserProfileEntity ue) throws SQLException, ClassNotFoundException {

    String sql ="Insert into user(name,nic,userName,password) values(?,?,?,?)";
      return  CrudUtil.executeUpdate(sql,
            ue.getName(),ue.getNic(),ue.getUserName(),ue.getTxtPassword()
                );

    }

    @Override
    public boolean update(UserProfileEntity userProfileEntity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public UserProfileEntity get(String s) {
        return null;
    }

    @Override
    public ArrayList<UserProfileEntity> getAll() {
        return null;
    }
}

