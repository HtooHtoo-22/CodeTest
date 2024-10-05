<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Product List</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light gray background */
            color: #343a40; /* Dark text */
            font-family: 'Myanmar Text', sans-serif; /* Optional: Use a Myanmar font if available */
        }
        .header {
            background-color: #8e44ad; /* Muted purple header */
            color: #ffffff; /* White text */
            padding: 20px 0;
            border-radius: 8px; /* Rounded corners */
        }
        .table {
            background-color: #ffffff; /* White for the table */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }
        .thead-dark {
            background-color: #27ae60; /* Deep green header */
            color: #ffffff; /* White text in header */
        }
        .btn-primary {
            background-color: #f39c12; /* Gold button */
            border: none;
        }
        .btn-success {
            background-color: #2980b9; /* Navy for cart button */
            border: none;
            color: #ffffff; /* White text on button */
        }
        .btn:hover {
            opacity: 0.9; /* Slightly darken on hover */
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h1 class="text-center header">Available Products</h1>
    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Action</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${product}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.product_name}</td>
                    <td>${product.brand}</td>
                    <td>${product.price}</td>
                    <td><img src="data:image/jpeg;base64,${product.get()}" alt="Image from database" width="100" height="100"/></td>
                    <td><a href="addtocart?id=${product.id}" class="btn btn-primary">Add to Cart</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <a href="showcart" class="btn btn-success">Show My Cart</a>
    </div>
</div>

<!-- Bootstrap JS (Optional, for dropdowns, modals, etc.) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
