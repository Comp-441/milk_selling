<%-- 
    Document   : index
    Created on : Nov 15, 2019, 7:03:59 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Section attendant</title>

    <link rel="stylesheet" href="../includes/commonFiles/CSS/styleSheet/style.css">
    <link rel="stylesheet" href="../includes/commonFiles/CSS/styleSheet/inPut/formStyle.css">
    <link rel="stylesheet" href="../includes/commonFiles/CSS/styleSheet/inPut/tableStyle.css">


<link rel="stylesheet" href="../includes/commonFiles/CSS/bootstrap.min.css">
<link rel="stylesheet" href="../includes/commonFiles/CSS/MDB/css/mdb.min.css">

<link rel="stylesheet" type="text/css" href="../includes/commonFiles/CSS/MDB/css/style.min.css">


  </head>
  <body>
   <div id="wrapper">
      <!-- Sidebar -->
      <div id="sidebar-wrapper">

        <ul class="sidebar-nav">
              <li id="sales"><a> <span id=""><i class="fas fa-chart-bar"></i></span> Sales </a></li>
              <li id="notification"><a> <span id=""><i class="fas fa-users menu-icon"></i></span> Production</a></li>
              <li id="clientsNotification"><a> <span id=""><i class="fas fa-users menu-icon"></i></span> Cows </a></li>
        </ul>
      </div>
      <!-- Sidebar -->

      <!-- Page content-->
      <div  id="page-content-wrapper">
        <div class="container-fluid">

            <div class="" style="width: 100%; position: relative;">


              <div class="row"  id="header">
                <div class="col-sm-1 col-md-1">
                    <div     id="menu-toggle">
                       <span id="breadcrump"></span>
                       <span id="breadcrump"></span>
                       <span id="breadcrump"></span>
                    </div>
                </div>

                 <!-- department heading -->
                <div class="col-sm-11 col-md-11 col-lg-11">
                   <center><h1>Milk Sale POS</h1></center>
                </div>
              </div>

          </div>

          <div class="row" id="production" style="margin: 0px; padding: 6px">
              <%@include file="inputForms/AddCow.html" %>                                                  
            </div>
            <div class="row">
                <div class="col-lg-12">
                </div>
            </div>
           </div>

            </div>
          </div>


         <script src="../includes/commonFiles/CSS/Scripts/js/bootstrap.min.js"></script>
         <script src="../includes/commonFiles/CSS/Scripts/js/jquery-3.3.1.min.js"></script>
         <script src="../includes/commonFiles/CSS/MDB/js/mdb.min.js"></script>
         <script src="../includes/commonFiles/CSS/Scripts/js/script.js"></script>
  </body>
</html>

