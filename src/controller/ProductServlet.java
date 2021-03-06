package controller;

import model.Category;
import model.Product;
import model.ProductResponse;
import service.category.CategoryServiceImpl;
import service.category.ICategoryService;
import service.product.IProduct;
import service.product.ProductImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private final IProduct productService = new ProductImpl();
    private final ICategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createProduct":
                    createProduct(request, response);
                    break;
                case "editProduct":
                    editProduct(request, response);
                    break;
                case "deleteProduct":
                    removeProduct(request, response);
                    break;
                case "searchProduct":
                    searchProductByName(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createProduct":
                    showCreateForm(request, response);
                    break;
                case "editProduct":
                    showEditForm(request, response);
                    break;
                case "deleteProduct":
                    showRemoveForm(request, response);
                    break;
                case "searchProduct":
                    searchProductByName(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> productList = productService.findAllByName(name);
        request.setAttribute("list", productList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        listProduct(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String categoryName = request.getParameter("categoryName");

        Product product = new Product(id, name, price, quantity, color, description, categoryName);
        Category category = new Category(categoryName);
        productService.updateProduct(product, category);
        response.sendRedirect("/product");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("categoryName"));

        Product product = new Product(name, price, quantity, color, description, id_category);
//        Category category = new Category(categoryName);
        productService.insertProduct(product);
        listProduct(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<ProductResponse> list = productService.showListProducts();
        request.setAttribute("list", list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showRemoveForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        List<ProductResponse> productList = productService.showListProducts();
        request.setAttribute("product", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/create.jsp");
        requestDispatcher.forward(request, response);
    }
}
