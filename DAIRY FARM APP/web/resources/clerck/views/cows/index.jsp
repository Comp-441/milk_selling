<%-- 
    Document   : index
    Created on : Nov 26, 2019, 1:53:48 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Clerk</title>

   <link rel="stylesheet" href="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/styleSheet/style.css">
   <link rel="stylesheet" href="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/bootstrap.min.css">
   <link rel="stylesheet" href="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/MDB/css/mdb.min.css">
   <link rel="stylesheet" type="text/css" href="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/MDB/css/style.min.css">


  </head>
  <body>
   <div id="wrapper">
      <!-- Sidebar -->
      <div id="sidebar-wrapper">

        <ul class="sidebar-nav">
            <li id="Cows"><a  href="../cows/"> <span id="Cow"><i class="fas fa-chart-bar"></i></span> Cows </a></li>
            <li id="Produce"><a href="../produce/"> <span id="Produc"><i class="fas fa-users menu-icon"></i></span> Produce</a></li>
            <li id="sales"><a href="../sales/"> <span id="sale"><i class="fas fa-users menu-icon"></i></span> Sales </a></li>
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
              <div class="col-lg-12">
                  <button id="toggleShown" class="btn btn-success" style="float: right;" onclick="changeToInputandBack('Add new cow')">
                      Add new cow
                  </button>
              </div>
              
              
              <div class="col-lg-12">
                  <div class="row" id="show">
                      <div class="col-lg-6">
                      <%@include file="inputForms/ViewCows.jsp" %> 
                      </div> 
                  </div> 
                  <div class="row" id="hide">
                      <div class="col-lg-6" >
                          <%@include file="inputForms/AddCow.html" %>
                      </div>  
                  </div>
              </div>
                 
              
              
              
            </div>
            <div class="row">
                <div class="col-lg-12">
                </div>
            </div>
           </div>

            </div>
          </div>


         <script src="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/Scripts/js/bootstrap.min.js"></script>
         <script src="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/Scripts/js/jquery-3.3.1.min.js"></script>
         <script src="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/MDB/js/mdb.min.js"></script>
         <script src="/DAIRY FARM APPLICATION/resources/includes/commonFiles/CSS/Scripts/js/script.js"></script>
  </body>
</html>

