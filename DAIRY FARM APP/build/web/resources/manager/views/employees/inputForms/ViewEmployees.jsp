<%-- 
    Document   : ViewCows
    Created on : Nov 26, 2019, 3:45:33 PM
    Author     : root
--%>

<%@page import="person.employees.Employee"%>
<%@page import="reports.employees.EmployeeReport"%>
<%@page import="production.cow.Cow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reports.ProductionReport.CowsReport"%>
<center>

	<h2>Employee</h2>
        <table class="table table-sm" id="myTable">
            <thead>   
             <tr>
                 <th>First Name</th>
	         <th>Last name</th>
		 
	     </tr>   
            </thead>
             <tbody>
                 
            <% 
            
             EmployeeReport report=new EmployeeReport(); 
            
             ArrayList<Employee> list= report.getEmployeesReport();
            
            for(Employee employee:list){
            %>
            <tr>
                <td><%=employee.getFirstName() %></td>
                <td><%=employee.getSecondName() %></td>
            </tr>
            
            <%}%>
                
                
	  </tbody>	
	</table>
	</center>
