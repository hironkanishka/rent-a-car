package service;

import dao.CategoryDao;
import dao.DaoFactory;
import dto.CategoryDto;
import entity.CategoryEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao cd= (CategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CATEGORY);
    @Override
    public boolean saveCategory(CategoryDto dto) throws SQLException, ClassNotFoundException {
        CategoryEntity ce =new CategoryEntity(dto.getCategoryId(),dto.getCategoryName());

        return cd.save(ce);

    }

    @Override
    public boolean updateCategory(CategoryDto dto) throws SQLException, ClassNotFoundException {
       return  cd.update(new CategoryEntity(dto.getCategoryId() ,dto.getCategoryName()));

    }

    @Override
    public boolean deleteCategory(String id) throws SQLException, ClassNotFoundException {
        return  cd.delete(id);
    }

    @Override
    public CategoryDto getCategory(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CategoryDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CategoryEntity> categoryEntities= cd.getAll();
ArrayList<CategoryDto> cdtos =new ArrayList<>();
       for(CategoryEntity ce : categoryEntities )
       {
            CategoryDto dto =new CategoryDto(ce.getCategoryId(),ce.getCategoryName());
            cdtos.add(dto);
       } return cdtos;

    }
}
