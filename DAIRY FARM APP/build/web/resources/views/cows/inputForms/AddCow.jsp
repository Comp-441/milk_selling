

<!-- Material form login -->
<div class="card">

    <h5 class="card-header  white-text text-center py-4" style="background-color: #555E">
    <strong>Add new Cow</strong>
  </h5>

  <!--Card content-->
  <div class="card-body px-lg-5 pt-0">

    <!-- Form -->
    <form class="text-center" style="color: #757575;"> 
         <!-- Password -->
      <div class="md-form">
          <input type="text" id="cow_id" value="${cow_id}"  class="form-control" readonly="">
        <label for="cow_id">Cow ID</label>
      </div>
        
      <!-- Email -->
      <div class="md-form">
        <input type="text" id="cow_name"  class="form-control">
        <label for="cow_name">Cow Name</label>
      </div>

      <!-- Sign in button -->
      <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="button" onclick="addCow()">Add</button>

    </form>
    <!-- Form -->

  </div>
        
  

</div>
<!-- Material form login -->
