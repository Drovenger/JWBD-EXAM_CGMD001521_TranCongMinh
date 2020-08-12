//package test;
//
//import main.java.model.Catalog;
//import main.java.service.product.ProductServiceImp;
//import org.junit.jupiter.api.Test;
//
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
////import org.junit.jupiter.api.Test;
//
//
//class ProductServiceImpTest {
//
////    @Test
////    void getProductByID() {
////        IProductService service = new ProductServiceImp();
////        try {
////            System.out.println(service.getProductByID(3));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
//
//    @Test
//    void getProductList() throws SQLException {
//        ProductServiceImp serviceImp = new ProductServiceImp();
//        Catalog catalog = new Catalog();
//        catalog.setCatalogID(2);
//        System.out.println(serviceImp.getProductList(catalog));
//    }
//}