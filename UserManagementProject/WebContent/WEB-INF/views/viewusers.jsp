<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
//on load of this page request server to get the userdetails from the server 
$(document).ready(function(){
  
        
        $.post("/UserManagementProject/viewUser",
                {
                  type : "viewuser"
                 
                },
                function(data,status){
                    if(status=="success")//got response from server
                   	{
                    	alert(data);
                    	var x="";
                    	var obj = JSON.parse(data);
                    	for (i in obj) {
                    	    		 x += "<B>Full Name :" + obj[i].firstName +" "+obj[i].lastName+"</B><br>";
                    		  }
                   		
                   		
                   	}
                    document.getElementById("result").innerHTML = x;
                });
   
}); 
</script>
</head>
<body>

<div id="result"></div>

</body>
</html> 