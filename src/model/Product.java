package model;

public class Product {
    private int id;
    private String product_name;
    private int price;
    private int quantity;
    private String color;
    private String description;
    private int id_category;

    public Product() {
    }

    public Product(String product_name, int price, int quantity, String color, String description, int id_category) {
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
    }

    public Product(int id, String product_name, int price, int quantity, String color, String description, int id_category) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
