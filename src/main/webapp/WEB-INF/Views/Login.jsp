<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light gray background */
            color: #343a40; /* Dark text */
            font-family: 'Myanmar Text', sans-serif; /* Optional: Use a Myanmar font if available */
        }
        .login-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff; /* White background for the form */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }
        .header {
            background-color: #8e44ad; /* Muted purple header */
            color: #ffffff; /* White text */
            text-align: center;
            padding: 10px;
            border-radius: 8px 8px 0 0; /* Rounded corners for the header */
        }
    </style>
</head>
<body>

<div class="login-container">
    <div class="header">
        <h3>Login</h3>
    </div>
    
    <form:form modelAttribute="userObj" action="dologin" method="post">
        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="email" class="form-control" id="email" />
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:input path="password" class="form-control" id="password" type="password" />
        </div>
        <button type="submit" class="btn btn-success btn-block">Login</button>
    </form:form>
    
    <div class="text-center mt-3">
        <a href="viewregister">Create Account</a>
    </div>
</div>

<!-- Bootstrap JS (Optional, for dropdowns, modals, etc.) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
