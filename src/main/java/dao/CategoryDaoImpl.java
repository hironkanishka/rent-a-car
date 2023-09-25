package dao;

import dao.util.CrudUtil;
import entity.CategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public boolean save(CategoryEntity ce) throws SQLException, ClassNotFoundException {
       String sql="Insert into category values(?,?)";
        return  CrudUtil.executeUpdate(sql,ce.getCategoryId(),ce.getCategoryName());

    }

    @Override
    public boolean update(CategoryEntity ce) throws SQLException, ClassNotFoundException {
        String sql="Update category set categoryName = ? where categoryId= ? ";
        return  CrudUtil.executeUpdate(sql,ce.getCategoryName(),ce.getCategoryId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql="Delete from category where categoryId= ? ";
        return  CrudUtil.executeUpdate(sql,s);

    }

    @Override
    public CategoryEntity get(String s) {
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws SQLException, ClassNotFoundException {
        String sql="select * from category";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<CategoryEntity> categoryEntities =new ArrayList<>();
        while (rst.next()){
            CategoryEntity ce =new CategoryEntity(rst.getString(1),rst.getString(2));
                categoryEntities.add(ce);
        } return categoryEntities;
    }
}
