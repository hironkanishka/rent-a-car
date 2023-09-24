package service;

import dto.UserProfileDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService extends SuperService{
 boolean saveUser(UserProfileDto dto) throws SQLException, ClassNotFoundException;
    boolean updateUser(UserProfileDto dto) throws SQLException, ClassNotFoundException;
     boolean deleteUser(String id) throws SQLException, ClassNotFoundException;
    UserProfileDto  getUser(String id) throws SQLException, ClassNotFoundException;
  ArrayList<UserProfileDto>  getAll() throws SQLException, ClassNotFoundException;
}
