<%-- 
    Document   : menu_items
    Created on : Dec 4, 2019, 2:51:15 PM
    Author     : root
--%>
           <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


            <li id="cows"><a> <span id="Cow"><i class="fas fa-chart-bar"></i></span> Cows </a></li>
            <li id="produce"><a href="ViewProduction"> <span id="Produc"><i class="fas fa-users menu-icon"></i></span> Produce</a></li>
            <li id="sales"><a href="RetrieveSales"> <span id="sale"><i class="fas fa-users menu-icon"></i></span> Sales </a></li>
            <c:if test="${ category == 'Manager'}">
             <li id="employees"><a href="viewEmployees"> <span id="sale"><i class="fas fa-users menu-icon"></i></span> Employees </a></li>
            </c:if>
