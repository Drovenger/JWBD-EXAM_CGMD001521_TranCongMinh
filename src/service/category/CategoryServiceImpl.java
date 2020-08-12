package service.category;

import util.*;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private Connection connection;
    private PreparedStatement statement;

    public void CategoryServiceImp() {
        connection = DBHandle.getConnection();
    }

    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        statement = connection.prepareStatement(Query.selectAllCategory);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("category_name");
            Category category = new Category(id, name);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Integer findIdByCategoryName(String categoryName) throws SQLException {
        Integer id = null;

        statement = connection.prepareStatement(Query.findByNameCategory);

        statement.setString(1, "%" + categoryName + "%");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return id;
    }
}
