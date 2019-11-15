//Open and close menu
$("#menu-toggle").click( function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("menuDispalyed");

 });

 $(document).ready(function(){
    $("#sales").click(function(){
      $("#production").load("inputForms/ViewSales.html");
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