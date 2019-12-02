<%-- 
    Document   : ViewCows
    Created on : Nov 26, 2019, 3:45:33 PM
    Author     : root
--%>

<%@page import="production.cow.Cow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reports.ProductionReport.CowsReport"%>
<center>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<h2>Cows Milked</h2>
        <table class="table table-sm" id="myTable">
            <thead>   
             <tr>
                 <th>Cow ID</th>
	         <th>Cow Name</th>
		 
	     </tr>   
            </thead>
             <tbody>
            
            <c:forEach var="cow" items="${cowsReport}" >
                <tr>
                  <td>${ cow.getId() }</td>
                  <td>${ cow.getUsername() }</td>
                </tr>
            </c:forEach> 
                
	  </tbody>	
	</table>
    </center>
