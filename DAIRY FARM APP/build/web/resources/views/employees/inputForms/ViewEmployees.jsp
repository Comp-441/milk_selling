<%-- 
    Document   : ViewCows
    Created on : Nov 26, 2019, 3:45:33 PM
    Author     : root
--%>

<center>

	<h2>Employee</h2>
        <table class="table table-sm table-bordered" id="myTable">
            <thead>   
             <tr>
                 <th>ID</th>
                 <th>First Name</th>
	         <th>Last name</th>
                 <th>date added</th>
                 <th>Phone number</th>
		 
	     </tr>   
            </thead>
             <tbody>
                
            <c:forEach var="employee" items="${employees}" >
               <tr>
                   <td>${ employee.getEmpId()       }</td>
                   <td>${ employee.getFirstName()   }</td>
                   <td>${ employee.getSecondName()  }</td>
                   <td>${ employee.getDateAdded()   }</td>
                   <td>${ employee.getPhoneNumber() }</td>
               </tr> 
            </c:forEach>
                
                
	  </tbody>	
	</table>
	</center>
