<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Order Success</title>
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
            margin-bottom: 20px;
        }
        .success-message {
            text-align: center;
            margin: 40px 0;
        }
        .btn {
            background-color: #27ae60; /* Deep green */
            color: #ffffff; /* White text */
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h1 class="header">Order Confirmation</h1>
    
    <div class="success-message">
        <h2>Order Success!</h2>
        <p>Thank you for your order. We will process it shortly.</p>
        <a href="index.html" class="btn btn-success">Return to Home</a>
    </div>
</div>

<!-- Bootstrap JS (Optional, for dropdowns, modals, etc.) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
