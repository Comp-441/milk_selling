<%-- 
    Document   : ViewSales
    Created on : Nov 27, 2019, 12:35:55 AM
    Author     : otieno David Odinga
--%>
<%@page import="person.employees.designation.Designation"%>
<%@page import="person.employees.Clerk"%>
<%@page import="java.sql.Date"%>
<%@page import="reports.SalesReport.SalesReport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="production.sales.Sales"%>
<%  
    
    HttpSession session1=request.getSession();
    
    ArrayList<Sales>  sales=(ArrayList<Sales>) session1.getAttribute("");
    if( sales == null ){
        sales= new SalesReport().viewSales(Date.valueOf("2010-10-07"), new Date(System.currentTimeMillis()), 0.00, 100.00, "all", Designation.Clerk);
    }

    
%>


	<h2 align="center">Sales Table</h2>
	
        <table class="table table-sm">
            <thead>
		<tr>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Total Amount</th>
		</tr>
            </thead>
            <tbody>
                
                <%
                for(Sales sale:sales){
                %>
		<tr>
                    <td><%=sale.getQuantity()%></td>
			<td>20 Ksh/L</td>
			<td>Ksh 400</td>
		</tr>
                <%}%>
            </tbody>

		
	</table>

