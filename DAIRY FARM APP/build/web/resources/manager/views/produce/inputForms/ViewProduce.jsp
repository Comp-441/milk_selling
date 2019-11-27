<%-- 
    Document   : ViewProduce
    Created on : Nov 26, 2019, 5:44:15 PM
    Author     : root
--%>

<%@page import="java.sql.Date"%>
<%@page import="reports.ProductionReport.ProductionReport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="production.produce.MilkProduced"%>
<%  
    
    ArrayList<MilkProduced>  produce=(ArrayList<MilkProduced>) request.getSession().getAttribute("");
    if( produce == null ){
      produce= new ProductionReport().productionReport(Date.valueOf("2010-10-07"), new Date(System.currentTimeMillis()), "all", 0.00, 100.00);
    }

    
%>

	<center>

	<h2>Production Table</h2>
        <table class="table table-sm">
            <thead>
                <tr>
			<th>Cow Name</th>
			<th></th>
			<th>Quantity Produced</th>
		</tr>
            </thead>
            <tbody>
		
                <% for( MilkProduced produced:produce){ %>
		<tr>
                      <td><%=produced.getCow().getUsername() %></td>
                      <td><%= produced.getQuantity() %></td>
			<td>20L</td>
		</tr>
                <%}%>
		
            </tbody>
		
	</table>
	</center>
