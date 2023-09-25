package service;
import dto.CategoryDto;


import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryService extends SuperService{

    boolean saveCategory(CategoryDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCategory(CategoryDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteCategory(String id) throws SQLException, ClassNotFoundException;
    CategoryDto  getCategory(String id) throws SQLException, ClassNotFoundException;
    ArrayList<CategoryDto> getAll() throws SQLException, ClassNotFoundException;
}
