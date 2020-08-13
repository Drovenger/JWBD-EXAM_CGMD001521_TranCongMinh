package util;

public class Query {
    public static final String selectAllProduct = "select p.id, p.product_name, p.price, p.quantity, p.color, p.description, category_name from product as p inner join category as c on p.id_category = c.id_category";
    public static final String insertProduct = "insert into product (product_name, price, quantity, color, description, id_category) values (?,?,?,?,?,?) ";
    public static final String updateProduct = "update product set product_name = ?, price = ?, quantity = ?, color = ?, description = ?, id_category = ? where id = ?";
    public static final String deleteProduct = "delete from product where id = ?";
    public static final String findByNameProduct = "SELECT * FROM product WHERE name LIKE ?";
    public static final String selectAllById = "select p.id, p.product_name, p.price, p.quantity, p.color, p.description, c.category_name from product as p inner join category as c on p.id_category = c.id_category where p.id";
    public static final String selectAllCategory = "select id_category, category_name from category";
    public static final String findByNameCategory = "select c.id_category from category as c where c.category_name like ?";
}
