<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function(){
    $("#submit").click(function(){
        var userNo = $("#userNo").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var emailId  = 	$("#emailId").val();
       
     
        
        $.post("/UserManagementProject/addUser",
                {
                  userNo : userNo ,
                  firstName : firstName,
                  lastName : lastName,
                  emailId : emailId
                },
                function(data,status){
                   alert("Data: " + data + "\nStatus: " + status);
                    if(status == "success")
                     {        
                    	document.getElementById("result").innerHTML=data;
                  	
                     	document.getElementById("userNo").value=""; 
                     	document.getElementById("firstName").value=""; 
                     	document.getElementById("lastName").value=""; 
                     	document.getElementById("emailId").value=""; 
                     }
                 
                });
    });
}); 
</script>
</head>
<body>
<B>Add User Details</B>

<div id="result"></div>
<table>
<tbody>

<tr><td><b>userNo : </b><input id="userNo" name="userNo" type="text" value=""/></td></tr><br/><br/>

<tr><td><b>FirstName : </b><input id="firstName" name="firstName" type="text" value=""/></td></tr><br/><br/>

<tr><td><b>LastName : </b> <input id="lastName" name="lastName" type="text" value=""/></td></tr><br/><br/>

<tr><td><b>User EmailID : </b> <input id="emailId" name="emailId" type="email" value=""/></td></tr><br/><br/>
<tr><td><input id="submit" type="button" value="Add User"/></td></tr>

</tbody>
</table>

</body>
</html> 