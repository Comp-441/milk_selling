
function addCow() {
    
    if(/^([a-z]{3,10}\s{0,1}){1,2}$/i.test($("#cow_name").val())){
        alert("valid")
    
  $.ajax({
      type: "POST",
      url: "http://localhost:8086/DAIRY FARM APPLICATION/AddCow",
      data: {cow_id  : $("#cow_id").val(), 
             cow_name: $("#cow_name").val()},
      dataType:'JSON',
      success: function(response){
            alert("Added successfully")             
            $("#cow_id").val(response.id);
            $("#cow_name").val("");

      },
      error:function (response) {
         alert("An error occured "+response.responseText)
            
//            var myObj = JSON.parse(response.responseText);
            
            console.log(response)
      }
  });
 }else{
     alert("invalid input: name can only be letters between 3 and 10 characters long")
 }
}

function loadData(end_point, field_to_populate){
     $.ajax({
      type: "POST",
      url: "http://localhost:8086/DAIRY FARM APPLICATION/"+end_point,
      data: {},
      dataType:'JSON',
      success: function(response){
          $("#body").html(""); 
             
            response[0].forEach(element => {
                
                var element="<tr>"+
                               "<td>"+element.id+"</td>"+
                               "<td>"+element.username+"</td>"+
                            "</tr>";
                
                $("#"+field_to_populate).append(element);
            });

      },
      error:function (response) {
         alert("An error occured "+response.responseText)
   
            console.log(response)
      }
  });
}


$("#cows").click(function (){
    loadData("cowsReportController?redirect=no","body");
})