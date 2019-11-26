//Open and close menu
$("#menu-toggle").click( function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("menuDispalyed");

 });
 
 
 $("#hide").hide();
 
 function changeToInputandBack(btnText){
 
// $("#toggleShown").click(function (){
     $("#hide").toggle();
     $("#show").toggle();
    
     
     if($("#toggleShown").text() === "<- Go back"){
         $("#toggleShown").text(btnText)
         $("#toggleShown").removeClass("btn-danger").addClass("btn-success");
     }
     else{
         $("#toggleShown").text("<- Go back");
         $("#toggleShown").removeClass("btn-success").addClass("btn-danger");
     }
// })
 
 }

 $(document).ready(function(){
    $("#sales").click(function(){
      $("#production").load("resources/inputForms/ViewSales.html");
    });
  });

  $(document).ready(function(){
    $("#notification").click(function(){
      $("#production").load("modules/notifications/displayNotification.php");
    });
  });

  $(document).ready(function(){
    $("#clientsNotification").click(function(){
      $("#production").load("modules/client/displayManager.php");
    });
  });