<%-- 
    Document   : ViewSales
    Created on : Nov 27, 2019, 12:35:55 AM
    Author     : otieno David Odinga
--%>



	<h2 align="center">Sales Table</h2>
	
        <table class="table table-sm table-bordered" id="myTable">
            <thead class="text-dark">
		<tr>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Total Amount</th>
		</tr>
            </thead>
            <tbody>
                
                <c:forEach var="sale" items="${salesReport}" >
                    <td>${ sale.getQuantity() }</td>
                    <td>40</td>
                    <td>${ sale.getQuantity()*40 }</td>
                </c:forEach>
                    
            </tbody>

		
	</table>

