package dao;

import dto.RentDto;
import entity.RentEntity;

import java.util.ArrayList;

public interface RentDao extends CrudDao<RentEntity,String>{
    ArrayList<RentEntity> getAllAvailable(String s) throws Exception;
}
