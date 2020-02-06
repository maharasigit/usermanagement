package com.usermanagement.controller;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usermanagement.bean.UserDetail;
import com.usermanagement.util.CommonUtil;




@Controller
public class UserManagementController {
	
	ArrayList<UserDetail> userDetailList = new ArrayList<UserDetail>();
    //show the usermain page 
	@RequestMapping(value = "/usermanagement", method = RequestMethod.GET)
	public String getUserMain(ModelMap model)
	{
        System.out.println("Inside the getUserMain Method");
		return "usermain";

	}
	//show the adduser page
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String getAddUserPage(ModelMap model)
	{
        System.out.println("Inside the getAddUserPage Method");
		return "adduser";

	}
	//show the updateuser page
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String getUpdateUserPage(ModelMap model)
	{
        System.out.println("Inside the getUpdateUserPage Method");
		return "updateuser";

	}
	//show the deleteuser page
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String getDeleteUserPage(ModelMap model)
	{
        System.out.println("Inside the getDeleteUserPage Method");
		return "deleteuser";

	}
//This method is to addUserDetails - get the input data from the client side 
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String addUserDetails(HttpServletRequest request,HttpServletResponse response) 
	{
		System.out.println("Inside the addUserDetails method");
		String userNo = request.getParameter("userNo");
	    String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailId = request.getParameter("emailId");
        
        UserDetail userDetail = new UserDetail();
        userDetail.setUserNo(userNo);
        userDetail.setFirstName(firstName);
        userDetail.setLastName(lastName);
        userDetail.setEmailId(emailId);
        userDetailList.add(userDetail);
       
        String userJson = "Added Successfully";
        System.out.println("Got userDetails from the client side - " +
        		"firstName is "+firstName+"and the lastName is "+lastName+"and the emailId is "+emailId);
		return userJson;

	}
    
    
    //This method is to updateUserDetail
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
   	public @ResponseBody String updateUserDetails(HttpServletRequest request,HttpServletResponse response) 
   	{
   		System.out.println("Inside the updatedUserDetails method");
   		String updateResponse = null;
   		String userNo = request.getParameter("userNo");
   	    String firstName = request.getParameter("firstName");
           String lastName = request.getParameter("lastName");
           String emailId = request.getParameter("emailId");
           

           System.out.println("Inside the updatedUserDetails "+userDetailList.size());
	   
          for(UserDetail userDetail : userDetailList)
           {
	         
	           if(userDetail.getUserNo().equals(userNo) )
	           {
	        	   userDetailList.remove(userDetail);
	        	   System.out.println("Updated User "+userNo);
	               userDetail.setUserNo(userNo);
	               userDetail.setFirstName(firstName);
	               userDetail.setLastName(lastName);
	               userDetail.setEmailId(emailId);
	               userDetailList.add(userDetail);
	               updateResponse="updated Successfully";
	               break;
	           }
	           
	       } 
	      
         
   		return updateResponse;

   	}
    //This method is to delete userDetail
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
   	public @ResponseBody String deleteUserDetail(HttpServletRequest request,HttpServletResponse response) 
   	{
   		System.out.println("Inside the addUserDetails method");
   		String deleteResponse =  null;
   		String userNo = request.getParameter("userNo");
   	    String firstName = request.getParameter("firstName");
           String lastName = request.getParameter("lastName");
           String emailId = request.getParameter("emailId");
           ListIterator<UserDetail>  iterator = userDetailList.listIterator(); 

     
           for(int i=0;i<userDetailList.size();i++)
           {
        	   UserDetail userDetail = userDetailList.get(i);
	           if(userDetail.getUserNo().equals(userNo))
	           {
	        	   System.out.println("Delete User"+userNo);
	               userDetailList.remove(userDetail);
	               deleteResponse = "Deleted Successfully";
	               break;
	           }
	       } 
	      
        
   		return deleteResponse;

   	}
    
   //show the viewuser page
    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public String getviewUserPage(ModelMap model)
	{
        System.out.println("Inside the getUpdateUserPage Method");
		return "viewusers";

	}
    
    //This method is to view all the userDetails 
    @RequestMapping(value = "/viewUser", method = RequestMethod.POST)
  	public @ResponseBody String viewAllUserDetails(HttpServletRequest request,HttpServletResponse response) 
  	{
  		
      CommonUtil commonUtil = new CommonUtil();
      String userJsonList = null;
      if(userDetailList != null)
    		userJsonList = commonUtil.convertObjectToJson(userDetailList);
    
      return userJsonList;

  	}

}
