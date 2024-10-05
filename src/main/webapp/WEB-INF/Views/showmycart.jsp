<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>My Cart</title>
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
            text-align: center;
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
        .btn-danger {
            background-color: #c0392b; /* Red for delete button */
            border: none;
        }
        .btn-danger:hover {
            opacity: 0.8; /* Slightly darken on hover */
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h1 class="header">My Cart</h1>
    
    <table class="table table-bordered mt-3">
        <thead class="thead-dark">
            <tr>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Action</th>
                <th>Photo</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${Cart == null}">
                <tr>
                    <td colspan="8" class="text-center"><h2>You have not added anything to your cart</h2></td>
                </tr>
            </c:if>
            <c:set var="totalamount" value="0" />
            <c:set var="counter" value="1" />
            <c:forEach var="cart" items="${Cart}">
                <tr>
                    <td>${counter}</td>
                    <td>${cart.product_id}</td>
                    <td>${cart.product_name}</td>
                    <td>${cart.brand}</td>
                    <td>${cart.price}</td>
                    <td>${cart.quantity}</td>
                    <td>${cart.quantity * cart.price}</td>
                    <td>
                        <form action="deleteFromCart" method="post">
                            <input type="submit" class="btn btn-danger" value="Delete">
                            <input type="hidden" name="id" value="${cart.cart_id}"/>
                        </form>
                    </td>
                    <td><img src="data:image/jpeg;base64,${cart.get64()}" alt="Image from database" width="100" height="100"/></td>
                </tr>
                <c:set var="counter" value="${counter + 1}" />
                <c:set var="totalamount" value="${totalamount + (cart.quantity * cart.price)}"/>
            </c:forEach>
        </tbody>
    </table>

    <h3>Total Amount = ${totalamount}</h3>
    <form action="order" method="post" class="mt-3">
        <input type="submit" class="btn btn-success" value="Order">
    </form>
</div>

<!-- Bootstrap JS (Optional, for dropdowns, modals, etc.) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
