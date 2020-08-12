package service.product;

import model.Category;
import model.Product;
import model.ProductResponse;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<ProductResponse> showListProducts() throws SQLException;

    Product selectProduct(int id) throws SQLException;

    void insertProduct(Product product, Category category) throws SQLException;

    boolean updateProduct(Product product, Category category) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    List<Product> findAllByName(String name) throws SQLException;

}
