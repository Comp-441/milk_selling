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

<!--     String firstName    = request.getParameter("firstName");
     String secondName   = request.getParameter("secondName");
     String dateOfBirth  = request.getParameter("dateOfBirth");
     String empId        = request.getParameter("passWord");
     String phoneNumber  = request.getParameter("phoneNumber");-->
    
<div class="container">
    <h2>Adding Customer form</h2>
    <form action="AddClerck" method="post">
        <div class="form-group">
            <label for="name">First Name:</label>
            <input type="name" class="form-control"   name="firstName" placeholder="Enter First name" >
        </div>
        <div class="form-group">
            <label for="name">Second Name:</label>
            <input type="name" class="form-control"    name="secondName" placeholder="Enter Second name" >
        </div>
        <div class="form-group">
            <label for="name">Date of Birth:</label>
            <input type="Date" class="form-control"    name="dateOfBirth">
        </div>
        <div class="form-group">
            <label for="DateAdded">Phone Number</label>
            <input type="text" class="form-control" name="phoneNumber" >
        </div>
        <div class="form-group">
            <label for="DateAdded">passWord:</label>
            <input type="password" class="form-control" name="passWord" >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
