<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<center>
    <h2>
        <a href="/product?action=listProduct">List All Products</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Update Product
                </h2>
            </caption>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' default="${list.getProduct_name()}"/>">
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' default="${list.getPrice()}" />">
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="<c:out value='${product.quantity}' default="${list.getQuantity()}" />">
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="<c:out value='${product.color}' default="${list.getColor()}" />">
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="15"
                           value="<c:out value='${product.description}' default="${list.getCategoryName()}" />">
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select class="custom-select" name="category">
                        <option selected>Choose...</option>
                        <option value="1">Phone</option>
                        <option value="2">Television</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="update"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
