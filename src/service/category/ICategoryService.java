package service.category;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
     List<Category> findAll() throws SQLException;

     Integer findIdByCategoryName(String categoryName) throws SQLException;
}
