<%-- 
    Document   : ViewProduce
    Created on : Nov 26, 2019, 5:44:15 PM
    Author     : root
--%>  

<!--//used for debugging--> 

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
	<center>

	<h2>Production Table</h2>
        <table class="table table-sm table-bordered" id="myTable">
            <thead>
                <tr>
                   <th>cow id</th>
		   <th>Cow Name</th>
                   <th>Date added</th>
                   <th>Remark</th>
		   <th>Quantity Produced</th>
		</tr>
            </thead>
            <tbody>   
                
            <c:forEach var="produce" items="${productionReport}" >
                <tr>
                  <td>${ produce.getCow().getId()}</td>
                  <td>${ produce.getCow().getUsername() }</td>
                  <td>${ produce.getDateAdded() }</td>
                  <td>${ produce.getRemarks() }</td>
                  <td>${ produce.getQuantity() }</td>
                </tr>
            </c:forEach> 
		
            </tbody>
		
	</table>
	</center>
