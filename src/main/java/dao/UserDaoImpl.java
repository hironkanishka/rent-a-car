package dao;


import dao.util.CrudUtil;
import entity.CarEntity;
import entity.UserProfileEntity;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {


    @Override
    public boolean save(UserProfileEntity ue) throws SQLException, ClassNotFoundException {

    String sql ="INSERT INTO user  VALUES (?,?, ?, ?, MD5(?))";
      return  CrudUtil.executeUpdate(sql,
            ue.getId(),ue.getName(),ue.getNic(),ue.getUserName(),ue.getTxtPassword()
                );

    }

    @Override
    public boolean update(UserProfileEntity ue) throws SQLException, ClassNotFoundException {

        String sql ="Update user SET name =?, userName=?, password= MD5(?) where userID =?";
        return  CrudUtil.executeUpdate(sql,
                ue.getName(),ue.getUserName(),ue.getTxtPassword(),ue.getId()
                );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="Delete from  user  where userID=? ";
        return  CrudUtil.executeUpdate(sql,s );

    }

    @Override
    public UserProfileEntity get(String s) throws SQLException, ClassNotFoundException {
        String sql="select * from user where userID=?";
        ResultSet rst = CrudUtil.executeQuery(sql,s);
        while (rst.next()){
            UserProfileEntity e =new UserProfileEntity(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getString(5));
            return e;
        } return null;
    }

    @Override
    public ArrayList<UserProfileEntity> getAll() throws SQLException, ClassNotFoundException {
        String sql="select * from user";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<UserProfileEntity> ue =new ArrayList<>();
        while (rst.next()){
            UserProfileEntity e =new UserProfileEntity(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5));
            ue.add(e);
        } return ue;
    }
}

