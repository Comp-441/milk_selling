<%-- 
    Document   : index
    Created on : Nov 26, 2019, 1:53:48 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      
    <c:import url="../../includes/commonFiles/top.jsp" />
 
  </head>
  <body>
   <div id="wrapper">
      <!-- Sidebar -->
      <div id="sidebar-wrapper">

        <ul class="sidebar-nav">
           <c:import url="../../includes/commonFiles/menu_items.jsp" />
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
                  
                <c:if test="${ category == 'Manager'}">
                  <div class="col-lg-12">
                      <button id="toggleShown" class="btn btn-success" style="float: left;" onclick="changeToInputandBack('Add new Clerk')">
                         Add new Clerk
                      </button>
                  </div>
                </c:if>
                      
                 <div class="row" id="show">
                      <div class="col-lg-6">
                        <%@include file="inputForms/ViewEmployees.jsp" %>
                      </div> 
                  </div> 
                      
                     
                   <c:if test="${ category == 'Manager'}">
                     <div class="row" id="hide">
                         <div class="col-lg-6" >
                             <c:import url="inputForms/add_clerk.jsp" />
                        </div>  
                     </div>
                   </c:if>
                      
              </div>
                 
              
            </div>
            
           </div>

            </div>
          </div>

      <c:import url="../../includes/commonFiles/bottom.html" />
  </body>
</html>

