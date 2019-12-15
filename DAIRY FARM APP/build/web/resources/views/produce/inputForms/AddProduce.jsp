
<%@page import="production.cow.Cow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="reports.ProductionReport.CowsReport"%>
<!-- Material form login -->
<div class="card">

    <h5 class="card-header  white-text text-center py-4" style="background-color: #555E">
    <strong>Add Produce</strong>
  </h5>

  <!--Card content-->
  <div class="card-body px-lg-5 pt-0">

    <!-- Form -->
    <form class="text-center" style="color: #757575;" action="../../../../AddProduce" method="post">

      <!-- Email -->
      <div class="md-form">
        
        <select name="cow_id"  class="form-control">
            <option selected disabled>-- select cow---</option>
            
           <c:forEach var="cow" items="${cowsReport}" >
                <option value="${ cow.getId() }">${ cow.getUsername() }</option> 
            </c:forEach>
         
            
        </select>
      </div>

      <!-- Password -->
      <div class="md-form">
        <input type="Number" name="quantity" id="materialLoginFormPassword" class="form-control">
        <label for="materialLoginFormPassword">Quantity</label>
      </div>

      <div class="form-group shadow-textarea">
         <label for="exampleFormControlTextarea6">Remarks</label>
         <textarea class="form-control z-depth-1" 
                   id="exampleFormControlTextarea6" 
                   rows="5"
                   placeholder="Produce remarks"
                   name="remarks">
                       
         </textarea>
      </div>
  

      <!-- Sign in button -->
      <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Add</button>

    </form>
    <!-- Form -->

  </div>

</div>
<!-- Material form login -->