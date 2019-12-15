<%-- 
    Document   : add_clerk
    Created on : Dec 4, 2019, 4:27:00 PM
    Author     : root
--%>



<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/12/19
  Time: 7:09 AM
  To change this template use File | Settings | File Templates.
--%>
    
<div class="card">
    <h5 class="card-header  white-text text-center py-4" style="background-color: #555E">
          <strong>Add new Clerk</strong>
    </h5>
    <div class="card-body px-lg-5 pt-0">
        <form action="AddClerck" method="post">
            
            <div class="md-form">
                <label for="id">Employee ID: { Auto generated } </label>
                <input type="text" class="form-control" name="passWord" value="${ employee_id }" readonly="" style="background-color: #57b846">
            </div>
            
            <div class="md-form">
                <label for="first_name">First Name:</label>
                <input type="text" id="first_name" class="form-control"   name="firstName" >
            </div>
            
            <div class="md-form">
                <label for="name">Second Name:</label>
                <input type="text" class="form-control"    name="secondName" >
            </div>
            
            <div class="md-form">
                <div class="form-row">
                   <div class="col">
                       <p>Date of birth</p>
                   </div>
                   <div class="col">
                    <input type="Date" class="form-control"    name="dateOfBirth">
                   </div> 
                </div>
               
                
            </div>
            
            <div class="md-form">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" class="form-control"     name="phoneNumber" >
            </div>
            
            
              <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="button" onclick="addCow()">
                  Add
              </button>
       </form>
    </div>                    
</div>
