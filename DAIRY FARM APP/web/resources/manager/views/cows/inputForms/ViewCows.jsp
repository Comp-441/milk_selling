<%-- 
    Document   : ViewCows
    Created on : Nov 26, 2019, 3:45:33 PM
    Author     : root
--%>

<%@page import="production.cow.Cow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reports.ProductionReport.CowsReport"%>
<center>

	<h2>Cows Milked</h2>
        <table class="table table-sm" id="myTable">
            <thead>   
             <tr>
                 <th>Cow ID</th>
	         <th>Cow Name</th>
		 
	     </tr>   
            </thead>
             <tbody>
                 
            <% 
            
             CowsReport report=new CowsReport(); 
            
             ArrayList<Cow> list=report.getCowsReport();
            
            for(Cow cow:list){
            %>
            <tr>
                <td><%=cow.getId() %></td>
                <td><%=cow.getUsername() %></td>
            </tr>
            
            <%}%>
                
                
	  </tbody>	
	</table>
	</center>
