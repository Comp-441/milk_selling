<%@ page import="database.Database" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/12/19
  Time: 7:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%--<%@ include file="adding/customer.html" %>--%>
<%--<% Database database=new Database();--%>
<%--   Connection connection=database.getConnection();--%>
<%--%>--%>
<div class="container">
    <h2>Adding Customer form</h2>
    <form action="resources/clerck/" method="post">
        <div class="form-group">
            <label for="name">FirstName:</label>
            <input type="name" class="form-control" name="name" placeholder="Enter First name" name="name">
        </div>
        <div class="form-group">
            <label for="name">SecondName:</label>
            <input type="name" class="form-control" name="name" placeholder="Enter Second name" name="name">
        </div>
        <div class="form-group">
            <label for="name">Customer ID:</label>
            <input type="ID" class="form-control" name="id" placeholder="Enter Customer ID" name="id">
        </div>
        <div class="form-group">
            <label for="name">Phone Number:</label>
            <input type="Phone" class="form-control" name="Phone" placeholder="Enter  Phone Number" name="Phone">
        </div>
        <div class="form-group">
            <label for="DateAdded">DateAdded:</label>
            <input type="Date" class="form-control" name="Date" placeholder="Enter DateAdded" name="Date">
        </div>
        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
